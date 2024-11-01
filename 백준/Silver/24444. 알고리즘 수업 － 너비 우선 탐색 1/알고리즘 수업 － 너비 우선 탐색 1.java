import java.util.*;
import java.io.*;

public class Main {
	static int n, m, r, cnt;
	static boolean[] visited;
	static int[] ans;
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

	static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		visited[x] = true;
		while (!q.isEmpty()) {
			x = q.poll();
			ans[x] = ++cnt;
			for (int nx : adj.get(x)) {
				if (visited[nx])
					continue;
				q.add(nx);
				visited[nx] = true;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		for (int i = 0; i <= n; i++)
			adj.add(new ArrayList<>());
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			adj.get(u).add(v);
			adj.get(v).add(u);
		}
		for (int i = 1; i <= n; i++)
			Collections.sort(adj.get(i));
		visited = new boolean[n + 1];
		ans = new int[n + 1];
		bfs(r);
		for (int i = 1; i <= n; i++)
			bw.write(ans[i] + "\n");
		bw.flush();
		bw.close();
	}
}