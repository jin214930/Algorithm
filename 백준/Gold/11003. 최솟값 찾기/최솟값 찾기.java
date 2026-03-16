import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int idx, x;

		public Node(int idx, int x) {
			this.idx = idx;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		Deque<Node> dq = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(st.nextToken());

			while (!dq.isEmpty() && dq.peekLast().x >= x) {
				dq.pollLast();
			}

			dq.addLast(new Node(i, x));

			if (dq.peekFirst().idx <= i - l)
				dq.pollFirst();

			bw.write(dq.peekFirst().x + " ");
		}

		bw.flush();
	}
}