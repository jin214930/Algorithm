import java.io.*;
import java.util.*;

public class Main {
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] a = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int time = 0;
		int cnt = -1;
		while (true) {
			List<Node> list = new ArrayList<>();
			Queue<Node> q = new LinkedList<>();
			boolean[][] visited = new boolean[n][m];
			q.add(new Node(0, 0));
			visited[0][0] = true;

			while (!q.isEmpty()) {
				Node node = q.poll();
				for (int i = 0; i < 4; i++) {
					int ny = node.y + dy[i];
					int nx = node.x + dx[i];
					if (ny < 0 || nx < 0 || ny >= n || nx >= m)
						continue;
					if (visited[ny][nx])
						continue;
					visited[ny][nx] = true;
					if (a[ny][nx] == 1) {
						list.add(new Node(ny, nx));
					} else {
						q.add(new Node(ny, nx));
					}
				}
			}

			if (list.isEmpty())
				break;

			time++;
			cnt = list.size();

			for (Node node : list) {
				a[node.y][node.x] = 0;
			}
		}

		bw.write(time + "\n" + cnt);

		bw.flush();
	}

	static class Node {
		int y, x;

		Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
