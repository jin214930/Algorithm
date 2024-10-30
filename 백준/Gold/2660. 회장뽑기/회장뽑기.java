import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[] visited;
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

	static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		visited[x] = 1;
		while (!q.isEmpty()) {
			x = q.poll();
			for (int nx : adj.get(x)) {
				if (visited[nx] >= 1)
					continue;
				visited[nx] = visited[x] + 1;
				q.add(nx);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		for (int i = 0; i <= n; i++)
			adj.add(new ArrayList<>());

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a == -1 && b == -1)
				break;
			adj.get(a).add(b);
			adj.get(b).add(a);
		}

		int[] d = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			visited = new int[n + 1];
			bfs(i);
			for (int j = 1; j <= n; j++)
				d[i] = Math.max(d[i], visited[j] - 1);
		}

		int mn = 100;
		int cnt = 0;
		for (int i = 1; i <= n; i++)
			mn = Math.min(mn, d[i]);
		for (int i = 1; i <= n; i++) {
			if (mn == d[i])
				cnt++;
		}
		System.out.print(mn + " " + cnt + "\n");
		for (int i = 1; i <= n; i++) {
			if (mn == d[i])
				System.out.print(i + " ");
		}
	}
}