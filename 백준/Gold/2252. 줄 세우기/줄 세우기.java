import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] cnt = new int[n + 1];
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i <= n; i++)
			adj.add(new ArrayList<>());
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj.get(a).add(b);
			cnt[b]++;
		}

		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			if (cnt[i] == 0)
				q.add(i);
		}

		while (!q.isEmpty()) {
			int x = q.poll();
			bw.write(x + " ");
			for (int nx : adj.get(x)) {
				cnt[nx]--;
				if (cnt[nx] == 0)
					q.add(nx);
			}
		}

		bw.flush();
		bw.close();
	}
}
