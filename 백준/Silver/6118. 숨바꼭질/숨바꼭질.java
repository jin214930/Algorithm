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
				q.add(nx);
				visited[nx] = visited[x] + 1;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		for (int i = 0; i <= n; i++)
			adj.add(new ArrayList<>());
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			adj.get(s).add(e);
			adj.get(e).add(s);
		}

		visited = new int[n + 1];
		bfs(1);

		int ans = 0, cnt = 0, mx = 0;
		for (int i = 1; i <= n; i++)
			mx = Math.max(mx, visited[i]);

		for (int i = 1; i <= n; i++) {
			if (mx == visited[i]) {
				cnt++;
				if (ans == 0)
					ans = i;
			}
		}

		bw.write(ans + " ");
		bw.write(mx - 1 + " ");
		bw.write(cnt + "");
		bw.flush();
		bw.close();
	}
}