import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] d = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			Arrays.fill(d[i], 1000000000);
			d[i][i] = 0;
		}

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			d[a][b] = Math.min(d[a][b], t);
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= n; k++)
					d[j][k] = Math.min(d[j][k], d[j][i] + d[i][k]);
			}
		}

		int k = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] c = new int[k];
		for (int i = 0; i < k; i++)
			c[i] = Integer.parseInt(st.nextToken());

		int[] ans = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			int mx = 0;
			for (int j : c)
				mx = Math.max(mx, d[j][i] + d[i][j]);
			ans[i] = mx;
		}

		int mn = 1000000000;
		for (int i = 1; i <= n; i++)
			mn = Math.min(mn, ans[i]);
		for (int i = 1; i <= n; i++) {
			if (mn == ans[i])
				bw.write(i + " ");
		}

		bw.flush();
		bw.close();
	}
}