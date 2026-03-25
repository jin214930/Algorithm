import java.io.*;
import java.util.*;

public class Main {
	static int n, m, ans = 0;
	static char[][] a;
	static List<Node> land = new ArrayList<>();
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		a = new char[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				a[i][j] = s.charAt(j);
				if (a[i][j] == 'L') {
					land.add(new Node(i, j));
				}
			}
		}

		for (Node node : land) {
			bfs(node);
		}

		bw.write((ans - 1) + "");

		bw.flush();
	}

	static void bfs(Node node) {
		Queue<Node> q = new LinkedList<>();
		int[][] visited = new int[n][m];
		q.add(node);
		visited[node.y][node.x] = 1;

		while (!q.isEmpty()) {
			Node cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				if (ny < 0 || nx < 0 || ny >= n || nx >= m)
					continue;
				if (a[ny][nx] == 'W' || visited[ny][nx] != 0)
					continue;
				q.add(new Node(ny, nx));
				visited[ny][nx] = visited[cur.y][cur.x] + 1;
			}
		}

		int ret = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				ret = Math.max(ret, visited[i][j]);
			}
		}

		ans = Math.max(ans, ret);
	}

	static class Node {
		int y, x;

		Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
