import java.util.*;
import java.io.*;

public class Main {
	static int n, c;
	static int[] a;

	static boolean check(int m) {
		int cnt = 1;
		int tmp = a[0];
		for (int i = 1; i < n; i++) {
			if (a[i] - tmp >= m) {
				cnt++;
				tmp = a[i];
			}
		}
		return cnt >= c;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(br.readLine());
		Arrays.sort(a);
		int s = 1, e = a[n - 1] - a[0], ans = 0;
		while (s <= e) {
			int m = (s + e) / 2;
			if (check(m)) {
				ans = m;
				s = m + 1;
			} else
				e = m - 1;
		}

		bw.write(ans + "");
		bw.flush();
		bw.close();
	}
}