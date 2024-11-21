import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] a = new int[n][m];
		int[][] d = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++)
				a[i][j] = Integer.parseInt(st.nextToken());
		}

		d[0][0] = a[0][0];
		for (int i = 1; i < m; i++)
			d[0][i] = d[0][i - 1] + a[0][i];

		for (int i = 1; i < n; i++) {
			int[][] tmp = new int[2][m];
			tmp[0][0] = d[i - 1][0] + a[i][0];
			for (int j = 1; j < m; j++)
				tmp[0][j] = Math.max(tmp[0][j - 1], d[i - 1][j]) + a[i][j];

			tmp[1][m - 1] = d[i - 1][m - 1] + a[i][m - 1];
			for (int j = m - 2; j >= 0; j--)
				tmp[1][j] = Math.max(tmp[1][j + 1], d[i - 1][j]) + a[i][j];

			for (int j = 0; j < m; j++)
				d[i][j] = Math.max(tmp[0][j], tmp[1][j]);
		}

		bw.write(d[n - 1][m - 1] + "");
		bw.flush();
		bw.close();
	}
}
