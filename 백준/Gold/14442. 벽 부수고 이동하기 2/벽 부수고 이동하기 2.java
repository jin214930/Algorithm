import java.util.*;
import java.io.*;

class Node {
	int y, x, b;

	public Node(int y, int x, int b) {
		this.y = y;
		this.x = x;
		this.b = b;
	}
}

public class Main {
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		char[][] a = new char[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++)
				a[i][j] = s.charAt(j);
		}

		Queue<Node> q = new LinkedList<>();
		int[][][] visited = new int[n][m][k + 1];
		q.add(new Node(0, 0, 0));
		visited[0][0][0] = 1;

		while (!q.isEmpty()) {
			Node node = q.poll();
			if (node.y == n - 1 && node.x == m - 1) {
				bw.write(visited[n - 1][m - 1][node.b] + "");
				bw.flush();
				bw.close();
				return;
			}

			for (int i = 0; i < 4; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
				if (ny < 0 || nx < 0 || ny >= n || nx >= m)
					continue;
				if (a[ny][nx] == '1' && node.b < k && visited[ny][nx][node.b + 1] == 0) {
					visited[ny][nx][node.b + 1] = visited[node.y][node.x][node.b] + 1;
					q.add(new Node(ny, nx, node.b + 1));
				} else if (a[ny][nx] == '0' && visited[ny][nx][node.b] == 0) {
					visited[ny][nx][node.b] = visited[node.y][node.x][node.b] + 1;
					q.add(new Node(ny, nx, node.b));
				}
			}
		}

		bw.write("-1");
		bw.flush();
		bw.close();
	}
}
