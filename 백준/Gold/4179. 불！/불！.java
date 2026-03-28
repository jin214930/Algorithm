import java.io.*;
import java.util.*;

public class Main {
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		Queue<Node> qP = new LinkedList<>();
		int[][] visited = new int[r][c];

		Queue<Node> qF = new LinkedList<>();
		int[][] fire = new int[r][c];

		char[][] a = new char[r][c];
		for (int i = 0; i < r; i++) {
			String s = br.readLine();
			for (int j = 0; j < c; j++) {
				a[i][j] = s.charAt(j);
				fire[i][j] = Integer.MAX_VALUE;
				if (a[i][j] == 'J') {
					qP.add(new Node(i, j));
					visited[i][j] = 1;
				} else if (a[i][j] == 'F') {
					qF.add(new Node(i, j));
					fire[i][j] = 1;
				}
			}
		}

		while (!qF.isEmpty()) {
			Node node = qF.poll();
			for (int i = 0; i < 4; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
				if (ny < 0 || nx < 0 || ny >= r || nx >= c)
					continue;
				if (a[ny][nx] == '#' || fire[ny][nx] != Integer.MAX_VALUE)
					continue;
				qF.add(new Node(ny, nx));
				fire[ny][nx] = fire[node.y][node.x] + 1;
			}
		}

		while (!qP.isEmpty()) {
			Node node = qP.poll();
			if (node.y == 0 || node.x == 0 || node.y == r - 1 || node.x == c - 1) {
				bw.write(visited[node.y][node.x] + "");
				bw.flush();
				return;
			}

			for (int i = 0; i < 4; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
				if (ny < 0 || nx < 0 || ny >= r || nx >= c)
					continue;
				if (a[ny][nx] == '#' || visited[ny][nx] != 0 || fire[ny][nx] <= visited[node.y][node.x] + 1)
					continue;
				qP.add(new Node(ny, nx));
				visited[ny][nx] = visited[node.y][node.x] + 1;
			}
		}

		bw.write("IMPOSSIBLE");

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
