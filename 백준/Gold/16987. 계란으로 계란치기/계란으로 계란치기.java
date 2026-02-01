import java.io.*;
import java.util.*;

public class Main {
	static class Egg {
		int s, w;

		public Egg(int s, int w) {
			this.s = s;
			this.w = w;
		}
	}

	static int n, ans;
	static Egg[] eggs;

	static void go(int x) {
		if (x == n) {
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				if (eggs[i].s <= 0)
					cnt++;
			}

			ans = Math.max(ans, cnt);
			return;
		}

		if (eggs[x].s <= 0) {
			go(x + 1);
			return;
		}

		boolean flag = false;
		for (int i = 0; i < n; i++) {
			if (i == x || eggs[i].s <= 0)
				continue;
			flag = true;
			eggs[x].s = eggs[x].s - eggs[i].w;
			eggs[i].s = eggs[i].s - eggs[x].w;
			go(x + 1);
			eggs[x].s = eggs[x].s + eggs[i].w;
			eggs[i].s = eggs[i].s + eggs[x].w;
		}

		if (!flag)
			go(x + 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		eggs = new Egg[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			eggs[i] = new Egg(s, w);
		}

		go(0);
		bw.write(ans + "\n");
		bw.flush();
	}
}