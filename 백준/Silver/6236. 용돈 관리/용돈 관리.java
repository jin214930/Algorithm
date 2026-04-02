import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[] a;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}

		int s = 1;
		int e = 1000000000;
		int ans = 0;
		while (s <= e) {
			int mid = (s + e) / 2;

			if (check(mid)) {
				e = mid - 1;
				ans = mid;
			} else {
				s = mid + 1;
			}
		}

		bw.write(ans + "");

		bw.flush();
	}

	static boolean check(int mid) {
		int sum = 0;
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (sum < a[i]) {
				sum = mid;
				cnt++;
			}
			if (sum < a[i])
				return false;
			sum -= a[i];
		}

		return cnt <= m;
	}

}
