import java.util.*;
import java.io.*;

public class Main {
	static int n, m, ans;
	static char[][] a;
	static boolean[][] visited, finish;
	static char[] d = { 'U', 'D', 'L', 'R' };
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static void dfs(int y, int x) {
		visited[y][x] = true;
		for (int i = 0; i < 4; i++) {
			if (a[y][x] != d[i])
				continue;
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (!visited[ny][nx])
				dfs(ny, nx);
			else if (!finish[ny][nx]) {
				ans++;
				int ty = y;
				int tx = x;
				while (true) {
					for (int j = 0; j < 4; j++) {
						if (a[ty][tx] == d[j]) {
							ty += dy[j];
							tx += dx[j];
							break;
						}
					}
					if (ty == y && tx == x)
						break;
				}
			}
			finish[y][x] = true;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new char[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++)
				a[i][j] = s.charAt(j);
		}

		visited = new boolean[n][m];
		finish = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (finish[i][j])
					continue;
				dfs(i, j);
			}
		}

		bw.write(ans + "");
		bw.flush();
		bw.close();
	}
}