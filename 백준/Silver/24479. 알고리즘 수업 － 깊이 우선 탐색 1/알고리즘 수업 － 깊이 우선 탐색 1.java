import java.util.*;
import java.io.*;

public class Main {
	static int n, cnt = 1;
	static boolean[] visited;
	static int[] ans;
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

	static void dfs(int x) {
		visited[x] = true;
		ans[x] = cnt++;

		for (int nx : adj.get(x)) {
			if (!visited[nx])
				dfs(nx);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= n; i++)
			adj.add(new ArrayList<>());

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj.get(a).add(b);
			adj.get(b).add(a);
		}

		for (int i = 1; i <= n; i++) {
			Collections.sort(adj.get(i));
		}

		visited = new boolean[n + 1];
		ans = new int[n + 1];
		dfs(r);
		for (int i = 1; i <= n; i++)
			System.out.println(ans[i]);
	}
}