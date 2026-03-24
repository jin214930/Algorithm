import java.io.*;
import java.util.*;

public class Main {
	static List<List<Integer>> adj = new ArrayList<>();
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= n; i++) {
			adj.add(new ArrayList<>());
		}

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			adj.get(b).add(a);
		}

		int[] cnt = new int[n + 1];
		visited = new boolean[n + 1];
		int max = 0;
		for (int i = 1; i <= n; i++) {
			Arrays.fill(visited, false);
			cnt[i] = dfs(i);
			max = Math.max(max, cnt[i]);
		}

		List<Integer> ans = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (cnt[i] == max) {
				ans.add(i);
			}
		}

		for (int i : ans) {
			bw.write(i + " ");
		}

		bw.flush();
	}

	static int dfs(int x) {
		visited[x] = true;
		int ret = 1;
		for (int nx : adj.get(x)) {
			if (visited[nx])
				continue;
			ret += dfs(nx);
		}

		return ret;
	}
}
