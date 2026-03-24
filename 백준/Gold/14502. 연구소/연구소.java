import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[][] a;
	static List<Node> list = new ArrayList<>();
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		a = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
				if (a[i][j] == 0) {
					list.add(new Node(i, j));
				}
			}
		}

		int ans = 0;
		for (int i = 0; i < list.size() - 2; i++) {
			for (int j = i + 1; j < list.size() - 1; j++) {
				for (int k = j + 1; k < list.size(); k++) {
					makeWall(i, j, k);
					ans = Math.max(ans, getSafetyArea());
					removeWall(i, j, k);
				}
			}
		}

		bw.write(ans + "");
		bw.flush();

	}

	static int getSafetyArea() {
		Queue<Node> q = new LinkedList<>();
		boolean[][] visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (a[i][j] == 2) {
					q.add(new Node(i, j));
					visited[i][j] = true;
				}
			}
		}

		while (!q.isEmpty()) {
			Node node = q.poll();
			for (int i = 0; i < 4; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
				if (ny < 0 || nx < 0 || ny >= n || nx >= m)
					continue;
				if (a[ny][nx] != 0 || visited[ny][nx])
					continue;
				q.add(new Node(ny, nx));
				visited[ny][nx] = true;
			}
		}

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (a[i][j] == 0 && !visited[i][j]) {
					cnt++;
				}
			}
		}

		return cnt;
	}

	static void makeWall(int i, int j, int k) {
		Node n1 = list.get(i);
		Node n2 = list.get(j);
		Node n3 = list.get(k);

		a[n1.y][n1.x] = 1;
		a[n2.y][n2.x] = 1;
		a[n3.y][n3.x] = 1;
	}

	static void removeWall(int i, int j, int k) {
		Node n1 = list.get(i);
		Node n2 = list.get(j);
		Node n3 = list.get(k);

		a[n1.y][n1.x] = 0;
		a[n2.y][n2.x] = 0;
		a[n3.y][n3.x] = 0;
	}

	static class Node {
		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
