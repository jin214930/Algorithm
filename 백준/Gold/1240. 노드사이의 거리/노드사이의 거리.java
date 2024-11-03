import java.util.*;
import java.io.*;

class Edge {
	int u, v, w;

	public Edge(int u, int v, int w) {
		this.u = u;
		this.v = v;
		this.w = w;
	}
}

public class Main {
	static ArrayList<Edge> adj = new ArrayList<>();
	static int n, a, b, ans;
	static boolean flag;
	static boolean[] visited;

	static void dfs(int x, int d) {
		if (flag)
			return;
		visited[x] = true;
		if (x == b) {
			ans = d;
			flag = true;
			return;
		}
		for (Edge e : adj) {
			if (e.u == x && !visited[e.v])
				dfs(e.v, d + e.w);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj.add(new Edge(u, v, w));
			adj.add(new Edge(v, u, w));
		}

		while (m-- > 0) {
			visited = new boolean[n + 1];
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			flag = false;
			dfs(a, 0);
			bw.write(ans + "\n");
		}

		bw.flush();
		bw.close();
	}
}