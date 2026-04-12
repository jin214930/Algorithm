import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int y1 = Integer.parseInt(st.nextToken()) - 1;
		int x1 = Integer.parseInt(st.nextToken()) - 1;
		int y2 = Integer.parseInt(st.nextToken()) - 1;
		int x2 = Integer.parseInt(st.nextToken()) - 1;

		char[][] a = new char[n][m];
		for (int i = 0; i < n; i++) {
			a[i] = br.readLine().toCharArray();
		}

		Deque<int[]> dq = new ArrayDeque<>();
		int[][] visited = new int[n][m];
		for (int i = 0; i < n; i++) {
			Arrays.fill(visited[i], Integer.MAX_VALUE);
		}
		
		dq.addFirst(new int[] {y1, x1});
		visited[y1][x1] = 0;
		int[] dy = {-1, 1, 0, 0};
		int[] dx = {0, 0, -1, 1};

		while (!dq.isEmpty()) {
			int[] cur = dq.pollFirst();
			int y = cur[0];
			int x = cur[1];

			if (y == y2 && x == x2)
				break;

			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];

				if (ny < 0 || nx < 0 || ny >= n || nx >= m)
					continue;
				if (a[ny][nx] == '0') {
					if (visited[ny][nx] > visited[y][x]) {
						dq.addFirst(new int[] {ny, nx});
						visited[ny][nx] = visited[y][x];
					}
				} else {
					if (visited[ny][nx] > visited[y][x] + 1) {
						dq.addLast(new int[] {ny, nx});
						visited[ny][nx] = visited[y][x] + 1;
					}
				}
			}
		}

		bw.write(visited[y2][x2] + "");

		bw.flush();
	}
}
