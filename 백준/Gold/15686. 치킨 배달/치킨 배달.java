import java.util.*;
import java.io.*;

class Node {
	int y, x;

	public Node(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Main {
	static int n, m, ans = 1000000000;
	static int[][] a;
	static ArrayList<Node> c = new ArrayList<>();
	static ArrayList<Node> h = new ArrayList<>();

	static void go(int idx, ArrayList<Node> al) {
		if (al.size() == m) {
			int sum = 0;
			for (Node i : h) {
				int cd = 1000000000;
				for (Node j : al) {
					int d = Math.abs(i.y - j.y) + Math.abs(i.x - j.x);
					cd = Math.min(cd, d);
				}
				sum += cd;
			}

			ans = Math.min(ans, sum);

			return;
		}

		for (int i = idx; i < c.size(); i++) {
			al.add(c.get(i));
			go(i + 1, al);
			al.remove(al.size() - 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
				if (a[i][j] == 1)
					h.add(new Node(i, j));
				else if (a[i][j] == 2)
					c.add(new Node(i, j));
			}
		}

		go(0, new ArrayList<>());

		bw.write(ans + "");
		bw.flush();
		bw.close();
	}
}
