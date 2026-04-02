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

		a = new int[m];
		int e = 0;
		for (int i = 0; i < m; i++) {
			a[i] = Integer.parseInt(br.readLine());
			e = Math.max(e, a[i]);
		}

		int s = 1;
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
		int cnt = 0;
		for (int i = 0; i < m; i++) {
			cnt += a[i] / mid;
			if (a[i] % mid != 0) {
				cnt++;
			}
		}

		return cnt <= n;
	}
}
