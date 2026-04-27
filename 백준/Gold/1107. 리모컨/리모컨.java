import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		boolean[] broken = new boolean[10];
		if (m != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				broken[Integer.parseInt(st.nextToken())] = true;
			}
		}

		int ans = Math.abs(n - 100);
		for (int i = 0; i < 1000000; i++) {
			int len = check(i, broken);

			if (len > 0) {
				ans = Math.min(ans, len + Math.abs(n - i));
			}
		}

		bw.write(ans + "");
		bw.flush();
	}

	static int check(int x, boolean[] broken) {
		if (x == 0) {
			return broken[0] ? 0 : 1;
		}

		int len = 0;
		while (x > 0) {
			if (broken[x % 10]) {
				return 0;
			}

			x /= 10;
			len++;
		}

		return len;
	}
}
