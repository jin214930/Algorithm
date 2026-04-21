import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int v, w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		List<Node>[] adj = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[a].add(new Node(b, w));
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		int[] d = new int[n + 1];
		Arrays.fill(d, Integer.MAX_VALUE);

		PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.w - n2.w);
		d[s] = 0;
		pq.add(new Node(s, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (cur.v == e)
				break;

			if (d[cur.v] < cur.w)
				continue;

			for (Node next : adj[cur.v]) {
				if (d[next.v] > cur.w + next.w) {
					d[next.v] = cur.w + next.w;
					pq.add(new Node(next.v, d[next.v]));
				}
			}
		}

		bw.write(d[e] + "");

		bw.flush();
	}
}
