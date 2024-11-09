import java.util.*;
import java.io.*;

public class Main {
	static int n, m, ans;
	static char[][] a;
	static int[][] c;
	static boolean[][] visited, ok;
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
			if (ny < 0 || nx < 0 || ny >= n || nx >= m || ok[ny][nx]) {
				ok[y][x] = true;
				return;
			}
			if (visited[ny][nx]) {
				int ty = y;
				int tx = x;
				int mn = 1000000000;
				while (true) {
					mn = Math.min(mn, c[ty][tx]);
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
				ans += mn;
			} else
				dfs(ny, nx);
			ok[y][x] = true;
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

		c = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++)
				c[i][j] = Integer.parseInt(st.nextToken());
		}

		visited = new boolean[n][m];
		ok = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (ok[i][j])
					continue;
				dfs(i, j);
			}
		}

		bw.write(ans + "");
		bw.flush();
		bw.close();
	}
}