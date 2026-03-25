import java.io.*;
import java.util.*;

public class Main {
	static int n, m, ans = Integer.MAX_VALUE;
	static List<Node> home = new ArrayList<>();
	static List<Node> chicken = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int x = Integer.parseInt(st.nextToken());
				if (x == 1)
					home.add(new Node(i, j));
				else if (x == 2)
					chicken.add(new Node(i, j));
			}
		}

		go(0, new ArrayList<>());

		bw.write(ans + "");

		bw.flush();
	}

	static void go(int idx, List<Integer> list) {
		if (list.size() == m) {
			ans = Math.min(ans, getChickenDist(list));
			return;
		}

		for (int i = idx; i < chicken.size(); i++) {
			list.add(i);
			go(i + 1, list);
			list.remove(list.size() - 1);
		}
	}

	static int getChickenDist(List<Integer> list) {
		int ret = 0;
		for (Node h : home) {
			int chickenDist = Integer.MAX_VALUE;

			for (int i : list) {
				Node c = chicken.get(i);
				int d = Math.abs(h.y - c.y) + Math.abs(h.x - c.x);
				chickenDist = Math.min(chickenDist, d);
			}
			ret += chickenDist;
		}

		return ret;
	}

	static class Node {
		int y, x;

		Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
