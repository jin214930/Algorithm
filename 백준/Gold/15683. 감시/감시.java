import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int y, x, n;

		public Node(int y, int x, int n) {
			this.y = y;
			this.x = x;
			this.n = n;
		}
	}

	static int n, m, ans = 100;
	static int[][] map;
	static List<Node> cameras = new ArrayList<>();
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] >= 1 && map[i][j] <= 5)
					cameras.add(new Node(i, j, map[i][j]));
			}
		}

		dfs(0, new boolean[n][m]);

		bw.write(ans + "");

		bw.flush();
	}

	static void dfs(int idx, boolean[][] check) {
		if (idx == cameras.size()) {
			int sum = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (!check[i][j] && map[i][j] == 0)
						sum++;
				}
			}

			ans = Math.min(ans, sum);
			return;
		}

		for (int d = 0; d < 4; d++) {
			boolean[][] tmp = new boolean[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++)
					tmp[i][j] = check[i][j];
			}

			Node camera = cameras.get(idx);
			fill(camera, d, tmp);
			dfs(idx + 1, tmp);
		}
	}

	static void fill(Node camera, int d, boolean[][] check) {
		int type = camera.n;

		if (type == 1) {
			go(camera.y, camera.x, d, check);
		} else if (type == 2) {
			go(camera.y, camera.x, d, check);
			go(camera.y, camera.x, (d + 2) % 4, check);
		} else if (type == 3) {
			go(camera.y, camera.x, d, check);
			go(camera.y, camera.x, (d + 1) % 4, check);
		} else if (type == 4) {
			go(camera.y, camera.x, d, check);
			go(camera.y, camera.x, (d + 1) % 4, check);
			go(camera.y, camera.x, (d + 2) % 4, check);
		} else {
			go(camera.y, camera.x, 0, check);
			go(camera.y, camera.x, 1, check);
			go(camera.y, camera.x, 2, check);
			go(camera.y, camera.x, 3, check);
		}

	}

	static void go(int y, int x, int d, boolean[][] check) {
		int ny = y;
		int nx = x;

		while (true) {
			ny += dy[d];
			nx += dx[d];

			if (ny < 0 || nx < 0 || ny >= n || nx >= m)
				break;
			if (map[ny][nx] == 6)
				break;

			check[ny][nx] = true;
		}
	}
}