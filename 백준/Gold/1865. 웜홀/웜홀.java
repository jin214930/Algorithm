import java.util.*;
import java.io.*;

class Edge {
	int s;
	int e;
	int w;

	public Edge(int s, int e, int w) {
		this.s = s;
		this.e = e;
		this.w = w;
	}
}

public class Main {
	static int n, m, w;
	static ArrayList<Edge> adj;

	public static boolean bf(int x) {
		int[] d = new int[n + 1];
		Arrays.fill(d, 1000000000);
		d[x] = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < 2 * m + w; j++) {
				Edge e = adj.get(j);
				if (d[e.e] > d[e.s] + e.w)
					d[e.e] = d[e.s] + e.w;
			}
		}

		for (int i = 0; i < 2 * m + w; i++) {
			Edge e = adj.get(i);
			if (d[e.e] > d[e.s] + e.w)
				return true;
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while (tc-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			adj = new ArrayList<>();

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				adj.add(new Edge(s, e, t));
				adj.add(new Edge(e, s, t));
			}

			for (int i = 0; i < w; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				adj.add(new Edge(s, e, -t));
			}

			if (bf(1))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}