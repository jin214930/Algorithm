import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int root = -1;
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(st.nextToken());
			if (x == -1) {
				root = i;
				continue;
			}

			adj.get(x).add(i);
			adj.get(i).add(x);
		}

		int rm = Integer.parseInt(br.readLine());

		if (rm == root) {
			bw.write("0");
		} else {
			Queue<Integer> q = new LinkedList<>();
			boolean[] visited = new boolean[n];
			q.add(root);
			visited[root] = true;

			int cnt = 0;
			while (!q.isEmpty()) {
				boolean flag = false;
				int x = q.poll();
				for (int nx : adj.get(x)) {
					if (visited[nx])
						continue;
					if (nx == rm)
						continue;
					flag = true;
					q.add(nx);
					visited[nx] = true;
				}

				if (!flag) {
					cnt++;
				}
			}

			bw.write(cnt + "");
		}

		bw.flush();
	}
}
