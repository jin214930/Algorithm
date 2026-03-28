import java.io.*;
import java.util.*;

public class Main {
	static int n, l, r, ans;
	static int[][] a;
	static boolean[][] visited;
	static List<Node> list;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		a = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			boolean flag = false;
			visited = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j]) {
						list = new ArrayList<>();
						int sum = dfs(i, j);
						if (list.size() != 1) {
							flag = true;
							int tmp = sum / list.size();
							for (Node node : list) {
								a[node.y][node.x] = tmp;
							}
						}
					}

				}
			}

			if (!flag)
				break;

			ans++;
		}

		bw.write(ans + "");

		bw.flush();
	}

	static int dfs(int y, int x) {
		visited[y][x] = true;
		int ret = a[y][x];
		list.add(new Node(y, x));
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny < 0 || nx < 0 || ny >= n || nx >= n)
				continue;
			if (visited[ny][nx] || Math.abs(a[y][x] - a[ny][nx]) < l || Math.abs(a[y][x] - a[ny][nx]) > r)
				continue;
			ret += dfs(ny, nx);
		}

		return ret;
	}

	static class Node {
		int y, x;

		Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
