import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[] d = new int[n + 1];
			int[] cnt = new int[n + 1];
			int[] ans = new int[n + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				d[i] = Integer.parseInt(st.nextToken());
				ans[i] = d[i];
			}
			ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
			for (int i = 0; i <= n; i++)
				adj.add(new ArrayList<>());
			while (k-- > 0) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				adj.get(x).add(y);
				cnt[y]++;
			}

			Queue<Integer> q = new LinkedList<>();
			for (int i = 1; i <= n; i++) {
				if (cnt[i] == 0)
					q.add(i);
			}

			while (!q.isEmpty()) {
				int x = q.poll();
				for (int nx : adj.get(x)) {
					cnt[nx]--;
					ans[nx] = Math.max(ans[nx], ans[x] + d[nx]);
					if (cnt[nx] == 0)
						q.add(nx);
				}
			}

			int w = Integer.parseInt(br.readLine());
			bw.write(ans[w] + "\n");
		}
		bw.flush();
		bw.close();
	}
}
