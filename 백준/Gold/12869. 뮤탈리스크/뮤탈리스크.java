import java.io.*;
import java.util.*;

public class Main {
	static int ans = Integer.MAX_VALUE;
	static int[][][] d = new int[61][61][61];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] a = new int[3];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		go(0, a[0], a[1], a[2]);

		bw.write(ans + "");

		bw.flush();
	}

	static void go(int cnt, int a, int b, int c) {
		a = Math.max(0, a);
		b = Math.max(0, b);
		c = Math.max(0, c);

		if (ans <= cnt) {
			return;
		}

		if (a == 0 && b == 0 && c == 0) {
			ans = Math.min(ans, cnt);
			return;
		}

		if (d[a][b][c] != 0 && d[a][b][c] <= cnt) {
			return;
		}

		d[a][b][c] = cnt;

		go(cnt + 1, a - 9, b - 3, c - 1);
		go(cnt + 1, a - 9, b - 1, c - 3);
		go(cnt + 1, a - 3, b - 9, c - 1);
		go(cnt + 1, a - 3, b - 1, c - 9);
		go(cnt + 1, a - 1, b - 9, c - 3);
		go(cnt + 1, a - 1, b - 3, c - 9);
	}
}
