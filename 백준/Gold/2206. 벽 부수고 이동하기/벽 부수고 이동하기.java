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
	static int n, m;
	static char[][] a;
	static int[][][] d;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0, 0));
		d[0][0][0] = 1;

		while (!q.isEmpty()) {
			Node node = q.poll();
			for (int i = 0; i < 4; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
				if (ny < 0 || nx < 0 || ny >= n || nx >= m)
					continue;
				if (a[ny][nx] == '1' && node.b == 0) {
					if (d[ny][nx][1] > d[node.y][node.x][0] + 1) {
						d[ny][nx][1] = d[node.y][node.x][0] + 1;
						q.add(new Node(ny, nx, 1));
					}
				} else if (a[ny][nx] == '0') {
					if (node.b == 1) {
						if (d[ny][nx][1] > d[node.y][node.x][1] + 1) {
							d[ny][nx][1] = d[node.y][node.x][1] + 1;
							q.add(new Node(ny, nx, 1));
						}
					} else {
						if (d[ny][nx][0] > d[node.y][node.x][0] + 1) {
							d[ny][nx][0] = d[node.y][node.x][0] + 1;
							q.add(new Node(ny, nx, 0));
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new char[n][m];
		d = new int[n][m][2];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				a[i][j] = s.charAt(j);
				d[i][j][0] = 1000000000;
				d[i][j][1] = 1000000000;
			}
		}

		bfs();

		if (d[n - 1][m - 1][0] == 1000000000 && d[n - 1][m - 1][1] == 1000000000)
			bw.write("-1");
		else
			bw.write(Math.min(d[n - 1][m - 1][0], d[n - 1][m - 1][1]) + "");
		bw.flush();
		bw.close();
	}
}