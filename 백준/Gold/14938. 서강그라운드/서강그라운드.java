import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int[] t = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++)
			t[i] = Integer.parseInt(st.nextToken());
		int[][] d = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			Arrays.fill(d[i], 1000000000);
			d[i][i] = 0;
		}

		while (r-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			d[a][b] = Math.min(d[a][b], c);
			d[b][a] = Math.min(d[b][a], c);
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= n; k++)
					d[j][k] = Math.min(d[j][k], d[j][i] + d[i][k]);
			}
		}

		int ans = 0;
		for (int i = 1; i <= n; i++) {
			int cnt = 0;
			for (int j = 1; j <= n; j++) {
				if (d[i][j] <= m)
					cnt += t[j];
			}
			ans = Math.max(ans, cnt);
		}

		bw.write(ans + "");
		bw.flush();
		bw.close();
	}
}