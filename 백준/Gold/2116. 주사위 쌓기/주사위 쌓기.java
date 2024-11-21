import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int a[][] = new int[n][6];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 6; j++)
				a[i][j] = Integer.parseInt(st.nextToken());
		}

		int ans = 0;
		int[] b = { 5, 3, 4, 1, 2, 0 };
		for (int i = 0; i < 6; i++) {
			int sum = 0;
			int tmp = a[0][b[i]];
			for (int j = 0; j < 6; j++) {
				if (j != i && j != b[i])
					sum = Math.max(sum, a[0][j]);
			}

			for (int j = 1; j < n; j++) {
				for (int k = 0; k < 6; k++) {
					if (tmp == a[j][k]) {
						tmp = a[j][b[k]];
						int mx = 0;
						for (int l = 0; l < 6; l++) {
							if (l != k && l != b[k])
								mx = Math.max(mx, a[j][l]);
						}
						sum += mx;
						break;
					}
				}
			}
			ans = Math.max(ans, sum);
		}

		bw.write(ans + "");
		bw.flush();
		bw.close();
	}
}
