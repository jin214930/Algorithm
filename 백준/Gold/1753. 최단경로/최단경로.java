import java.io.*;
import java.util.*;

public class Main {
	static class Edge {
		int v, w;

		public Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());

		List<Edge>[] adj = new ArrayList[v + 1];
		for (int i = 0; i <= v; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			adj[a].add(new Edge(b, w));
		}

		int[] d = new int[v + 1];
		Arrays.fill(d, Integer.MAX_VALUE);

		PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.w, e2.w));
		pq.add(new Edge(k, 0));
		d[k] = 0;
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();

			if (d[cur.v] < cur.w) {
				continue;
			}

			for (Edge next : adj[cur.v]) {
				if (d[next.v] > cur.w + next.w) {
					d[next.v] = cur.w + next.w;
					pq.add(new Edge(next.v, d[next.v]));
				}
			}
		}

		for (int i = 1; i <= v; i++) {
			bw.write((d[i] != Integer.MAX_VALUE ? d[i] + "\n" : "INF\n"));
		}

		bw.flush();
	}
}
