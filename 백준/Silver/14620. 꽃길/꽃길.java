import java.io.*;
import java.util.*;

public class Main {
	static int n, ans = Integer.MAX_VALUE;
	static int[][] a;
	static List<Node> list = new ArrayList<>();
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		a = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
				list.add(new Node(i, j));
			}
		}

		for (int i = 0; i < list.size() - 2; i++) {
			for (int j = i + 1; j < list.size() - 1; j++) {
				for (int k = j + 1; k < list.size(); k++) {
					ans = Math.min(ans, getCost(i, j, k));
				}
			}
		}

		bw.write(ans + "");

		bw.flush();
	}

	static int getCost(int p, int q, int r) {
		Node[] nodes = new Node[3];
		nodes[0] = list.get(p);
		nodes[1] = list.get(q);
		nodes[2] = list.get(r);

		int sum = 0;
		boolean[][] visited = new boolean[n][n];
		for (int i = 0; i < 3; i++) {
			int y = nodes[i].y;
			int x = nodes[i].x;
			sum += a[y][x];
			visited[y][x] = true;
			for (int j = 0; j < 4; j++) {
				int ny = y + dy[j];
				int nx = x + dx[j];
				if (ny < 0 || nx < 0 || ny >= n || nx >= n || visited[ny][nx]) {
					return Integer.MAX_VALUE;
				}
				sum += a[ny][nx];
				visited[ny][nx] = true;
			}
		}
		return sum;
	}

	static class Node {
		int y, x;

		Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
