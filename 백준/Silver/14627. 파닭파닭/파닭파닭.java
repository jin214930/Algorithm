import java.io.*;
import java.util.*;

public class Main {
	static int s, c;
	static int[] a;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		a = new int[s];
		int r = 0;
		long sum = 0;
		for (int i = 0; i < s; i++) {
			a[i] = Integer.parseInt(br.readLine());
			r = Math.max(r, a[i]);
			sum += a[i];
		}

		int l = 1;
		int len = 1;
		while (l <= r) {
			int m = (l + r) / 2;
			if (check(m)) {
				l = m + 1;
				len = m;
			} else {
				r = m - 1;
			}
		}

		long ans = sum - (long)c * len;

		bw.write(ans + "");

		bw.flush();
	}

	static boolean check(int m) {
		long cnt = 0;
		for (int i = 0; i < s; i++) {
			cnt += a[i] / m;
		}

		return cnt >= c;
	}
}
