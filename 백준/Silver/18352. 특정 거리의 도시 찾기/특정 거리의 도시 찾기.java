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
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= n; i++)
			adj.add(new ArrayList<>());
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj.get(a).add(b);
		}

		visited = new int[n + 1];
		bfs(x);

		boolean flag = true;
		for (int i = 1; i <= n; i++) {
			if (visited[i] == k + 1) {
				bw.write(i + "\n");
				flag = false;
			}
		}
		if (flag)
			bw.write("-1");
		bw.flush();
		bw.close();
	}
}