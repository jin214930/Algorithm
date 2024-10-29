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
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		for (int i = 0; i <= n; i++)
			adj.add(new ArrayList<>());

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj.get(a).add(b);
			adj.get(b).add(a);
		}

		int[] c = new int[n + 1];
		int mn = 999999999;
		for (int i = 1; i <= n; i++) {
			visited = new int[n + 1];
			bfs(i);
			int sum = 0;
			for (int j = 1; j <= n; j++) 
				sum += visited[j];
			c[i] = sum - n;
			mn = Math.min(c[i], mn);
		}

		for(int i = 1; i <=n;i++) {
			if(c[i] == mn) {
				System.out.println(i);
				break;
			}
		}
	}
}