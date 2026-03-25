import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		if (n >= k) {
			bw.write((n - k) + "\n1");
			bw.flush();
			return;
		}

		Queue<Node> q = new LinkedList<>();
		boolean[] visited = new boolean[200001];
		q.add(new Node(n, 0));
		visited[n] = true;

		int d = 0;
		int cnt = 0;
		while (!q.isEmpty()) {
			Node node = q.poll();

			visited[node.x] = true;

			if (cnt == 0 && node.x == k) {
				d = node.d;
				cnt++;
			} else if (node.d == d && node.x == k) {
				cnt++;
			}

			for (int nx : new int[] {node.x - 1, node.x + 1, node.x * 2}) {
				if (nx < 0 || nx > 200000 || visited[nx])
					continue;
				q.add(new Node(nx, node.d + 1));
			}
		}

		bw.write(d + "\n" + cnt);

		bw.flush();
	}

	static class Node {
		int x, d;

		Node(int x, int d) {
			this.x = x;
			this.d = d;
		}
	}
}
