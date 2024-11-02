import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	static boolean[] visited;
	static int[] cnt;
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

	static int dfs(int x) {
		int tmp = 1;
		visited[x] = true;
		for (int nx : adj.get(x)) {
			if (visited[nx])
				continue;
			tmp += dfs(nx);
			cnt[nx]++;
		}
		return tmp;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		for (int i = 0; i <= n; i++)
			adj.add(new ArrayList<>());
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj.get(a).add(b);
		}

		cnt = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			visited = new boolean[n + 1];
			cnt[i] += dfs(i);
		}

		int ans = 0;
		for (int i = 1; i <= n; i++) {
			if (cnt[i] == n)
				ans++;
		}
		bw.write(ans + "");
		bw.flush();
		bw.close();
	}
}