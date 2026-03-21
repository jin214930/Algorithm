import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[][] a;
	static boolean[][] visited;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		a = new int[n][m];
		while (k-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int i = y1; i < y2; i++) {
				for (int j = x1; j < x2; j++) {
					a[i][j] = 1;
				}
			}
		}

		int ans = 0;
		List<Integer> list = new ArrayList<>();
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (a[i][j] == 0 && !visited[i][j]) {
					list.add(dfs(i, j));
					ans++;
				}
			}
		}

		bw.write(ans + "\n");

		Collections.sort(list);
		for (int i : list)
			bw.write(i + " ");

		bw.flush();
	}

	static int dfs(int y, int x) {
		visited[y][x] = true;
		int ret = 1;

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny < 0 || nx < 0 || ny >= n || nx >= m)
				continue;
			if (a[ny][nx] == 1 || visited[ny][nx])
				continue;
			ret += dfs(ny, nx);
		}

		return ret;
	}
}
