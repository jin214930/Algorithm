import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n + 1];
		int[] cnt = new int[n + 1];
		int[] ans = new int[n + 1];
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i <= n; i++)
			adj.add(new ArrayList<>());

		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a[i] = Integer.parseInt(st.nextToken());
			ans[i] = a[i];
			cnt[i] = Integer.parseInt(st.nextToken());
			if (cnt[i] == 0)
				q.add(i);
			for (int j = 0; j < cnt[i]; j++) {
				int x = Integer.parseInt(st.nextToken());
				adj.get(x).add(i);
			}
		}

		while (!q.isEmpty()) {
			int x = q.poll();
			for (int nx : adj.get(x)) {
				cnt[nx]--;
				ans[nx] = Math.max(ans[nx], ans[x] + a[nx]);
				if (cnt[nx] == 0)
					q.add(nx);
			}
		}

		int tmp = 0;
		for (int i = 1; i <= n; i++)
			tmp = Math.max(tmp, ans[i]);

		bw.write(tmp + "");
		bw.flush();
		bw.close();
	}
}
