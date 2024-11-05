import java.util.*;
import java.io.*;

class Node {
	int y, x;

	public Node(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Main {
	static int n;
	static int[][] visited;
	static int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dx = { 1, 2, 2, 1, -1, -2, -2, -1 };

	static void bfs(int y, int x) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(y, x));
		visited[y][x] = 1;

		while (!q.isEmpty()) {
			Node node = q.poll();
			y = node.y;
			x = node.x;
		
			for (int i = 0; i < 8; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (ny < 0 || nx < 0 || ny >= n || nx >= n)
					continue;
				if (visited[ny][nx] >= 1)
					continue;
				q.add(new Node(ny, nx));
				visited[ny][nx] = visited[y][x] + 1;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());

		while(t-- > 0) {
			n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sy = Integer.parseInt(st.nextToken());
			int sx = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int ey = Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());
			
			visited = new int[n][n];
			bfs(sy, sx);

			bw.write((visited[ey][ex] - 1) + "\n");
		}
	
		bw.flush();
		bw.close();
	}
}