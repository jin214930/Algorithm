import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object o) {
			if (o == null || getClass() != o.getClass())
				return false;
			Node node = (Node)o;
			return x == node.x && y == node.y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		Set<Node> set = new HashSet<>();
		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			set.add(new Node(x, y));
		}

		String s = br.readLine();

		int x = 0;
		int y = 0;
		for (char c : s.toCharArray()) {
			int nx = x;
			int ny = y;
			if (c == 'U') {
				ny++;
			} else if (c == 'D') {
				ny--;
			} else if (c == 'R') {
				nx++;
			} else {
				nx--;
			}

			if (set.contains(new Node(nx, ny)))
				continue;

			x = nx;
			y = ny;
		}

		bw.write(x + " " + y);

		bw.flush();
	}
}