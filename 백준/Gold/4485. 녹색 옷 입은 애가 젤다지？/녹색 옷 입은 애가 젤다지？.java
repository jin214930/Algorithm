import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
	int y, x, c;

	public Node(int y, int x, int c) {
		this.y = y;
		this.x = x;
		this.c = c;
	}

	@Override
	public int compareTo(Node n) {
		return this.c - n.c;
	}
}

public class Main {
	static int n;
	static int[][] a, d;
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };

	static void dihkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		d = new int[n][n];
		for (int i = 0; i < n; i++)
			Arrays.fill(d[i], 1000000000);
		pq.add(new Node(0, 0, a[0][0]));
		d[0][0] = a[0][0];

		while (!pq.isEmpty()) {
			Node node = pq.poll();
			int y = node.y, x = node.x, c = node.c;

			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (ny < 0 || nx < 0 || ny >= n || nx >= n)
					continue;
				if (c + a[ny][nx] < d[ny][nx]) {
					d[ny][nx] = c + a[ny][nx];
					pq.add(new Node(ny, nx, d[ny][nx]));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int idx = 0;
		while (true) {
			idx++;
			n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;
			a = new int[n][n];

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++)
					a[i][j] = Integer.parseInt(st.nextToken());
			}

			dihkstra();

			bw.write("Problem " + idx + ": " + d[n - 1][n - 1] + "\n");
		}

		bw.flush();
		bw.close();
	}
}