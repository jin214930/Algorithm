import java.util.*;
import java.io.*;

class Node {
	int y, x, k;

	public Node(int y, int x, int k) {
		this.y = y;
		this.x = x;
		this.k = k;
	}
}

public class Main {
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dyh = { -2, -1, 1, 2, 2, 1, -1, -1 };
	static int[] dxh = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[][] a = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++)
				a[i][j] = Integer.parseInt(st.nextToken());
		}

		int[][][] visited = new int[n][m][k + 1];
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0, 0));
		visited[0][0][0] = 1;

		while (!q.isEmpty()) {
			Node node = q.poll();
			if (node.y == n - 1 && node.x == m - 1) {
				bw.write((visited[node.y][node.x][node.k] - 1) + "");
				bw.flush();
				bw.close();
				return;
			}
			for (int i = 0; i < 4; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
				if (ny < 0 || nx < 0 || ny >= n || nx >= m || a[ny][nx] == 1 || visited[ny][nx][node.k] >= 1)
					continue;
				q.add(new Node(ny, nx, node.k));
				visited[ny][nx][node.k] = visited[node.y][node.x][node.k] + 1;
			}

			if (node.k < k) {
				for (int i = 0; i < 8; i++) {
					int ny = node.y + dyh[i];
					int nx = node.x + dxh[i];
					if (ny < 0 || nx < 0 || ny >= n || nx >= m || a[ny][nx] == 1 || visited[ny][nx][node.k + 1] >= 1)
						continue;
					q.add(new Node(ny, nx, node.k + 1));
					visited[ny][nx][node.k + 1] = visited[node.y][node.x][node.k] + 1;
				}
			}
		}

		bw.write("-1");
		bw.flush();
		bw.close();
	}
}
