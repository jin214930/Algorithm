import java.util.*;
import java.io.*;

public class Main {
	static int[] a, s, b;
	static int ans;
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

	static void go(int idx, int sum) {
		if (idx == 10) {
			ans = Math.max(ans, sum);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (b[i] == 32)
				continue;
			int move_idx = move(b[i], a[idx]);
			if (check(move_idx))
				continue;
			int tmp = b[i];
			b[i] = move_idx;
			go(idx + 1, sum + s[b[i]]);
			b[i] = tmp;
		}
	}

	static int move(int x, int cnt) {
		if (adj.get(x).size() == 2) {
			x = adj.get(x).get(1);
			cnt--;
		}

		while (cnt-- > 0) {
			if (x == 32)
				break;
			x = adj.get(x).get(0);
		}

		return x;
	}

	static boolean check(int x) {
		if (x == 32)
			return false;
		for (int i = 0; i < 4; i++) {
			if (b[i] == x)
				return true;
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = new int[10];
		s = new int[33];
		b = new int[4];
		for (int i = 0; i < 10; i++)
			a[i] = Integer.parseInt(st.nextToken());

		for (int i = 0; i < 33; i++)
			adj.add(new ArrayList<>());

		for (int i = 0; i < 20; i++)
			adj.get(i).add(i + 1);
		adj.get(5).add(21);
		adj.get(21).add(22);
		adj.get(22).add(23);
		adj.get(23).add(24);
		adj.get(24).add(30);
		adj.get(30).add(31);
		adj.get(31).add(20);
		adj.get(20).add(32);
		adj.get(10).add(25);
		adj.get(25).add(26);
		adj.get(26).add(24);
		adj.get(15).add(27);
		adj.get(27).add(28);
		adj.get(28).add(29);
		adj.get(29).add(24);

		for (int i = 1; i <= 20; i++)
			s[i] = 2 * i;
		s[21] = 13;
		s[22] = 16;
		s[23] = 19;
		s[24] = 25;
		s[25] = 22;
		s[26] = 24;
		s[27] = 28;
		s[28] = 27;
		s[29] = 26;
		s[30] = 30;
		s[31] = 35;

		go(0, 0);

		bw.write(ans + "");
		bw.flush();
		bw.close();
	}
}
