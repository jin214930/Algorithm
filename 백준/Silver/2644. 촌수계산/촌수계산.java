import java.util.*;
import java.io.*;

public class Main {
	static int n, x, y, m, a, b;
	static int[] visited;
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

	static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		visited[x] = 1;
		while (!q.isEmpty()) {
			x = q.poll();
			if (x == b)
				break;
			for (int nx : adj.get(x)) {
				if (visited[nx] >= 1)
					continue;
				q.add(nx);
				visited[nx] = visited[x] + 1;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i <= n; i++)
			adj.add(new ArrayList<>());

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			adj.get(x).add(y);
			adj.get(y).add(x);
		}

		visited = new int[n + 1];
		bfs(a);

		bw.write((visited[b] - 1) + "");
		bw.flush();
		bw.close();
	}
}