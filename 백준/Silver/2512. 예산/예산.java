import java.io.*;
import java.util.*;

public class Main {
	static int n, k;
	static int[] a;

	static boolean check(int m) {
		int sum = 0;
		for (int i = 0; i < n; i++)
			sum += Math.min(a[i], m);

		return k >= sum;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());

		int s = 0;
		int e = 0;
		int ans = 0;

		a = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			e = Math.max(a[i], e);
		}

		k = Integer.parseInt(br.readLine());

		while (s <= e) {
			int m = (s + e) / 2;
			if (check(m)) {
				s = m + 1;
				ans = m;
			} else
				e = m - 1;
		}

		bw.write(ans + "");
		bw.flush();
	}
}