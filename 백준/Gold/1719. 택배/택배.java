import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int d[][] = new int[n + 1][n + 1];
		int ans[][] = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			Arrays.fill(d[i], 999999999);
			d[i][i] = 0;
		}

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			d[a][b] = Math.min(d[a][b], c);
			d[b][a] = Math.min(d[b][a], c);
			ans[a][b] = b;
			ans[b][a] = a;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= n; k++) {
					if (d[j][k] > d[j][i] + d[i][k]) {
						d[j][k] = d[j][i] + d[i][k];
						ans[j][k] = ans[j][i];
					}
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (ans[i][j] == 0)
					bw.write("- ");
				else
					bw.write(ans[i][j] + " ");
			}
			bw.write("\n");
		}

		// for (int i = 1; i <= n; i++) {
		// for (int j = 1; j <= n; j++)
		// System.out.print(d[i][j] + " ");
		// System.out.println();
		// }

		bw.flush();
		bw.close();
	}
}
