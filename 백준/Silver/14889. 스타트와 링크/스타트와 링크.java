import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[][] s;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		s = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				s[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		go(0, new HashSet<>());

		bw.write(ans + "");

		bw.flush();
	}

	static void go(int idx, Set<Integer> set) {
		if (set.size() == n / 2) {
			int sum1 = 0;
			int sum2 = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (set.contains(i) && set.contains(j)) {
						sum1 += s[i][j];
					} else if (!set.contains(i) && !set.contains(j)) {
						sum2 += s[i][j];
					}
				}
			}

			ans = Math.min(ans, Math.abs(sum1 - sum2));

			return;
		}

		for (int i = idx; i < n; i++) {
			set.add(i);
			go(i + 1, set);
			set.remove(i);
		}
	}
}
