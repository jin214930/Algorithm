import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int d[][] = new int[n + 1][n + 1];
		int ans[][] = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			Arrays.fill(d[i], 999999999);
			d[i][i] = 0;
		}

		while (m-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			d[a][b] = Math.min(d[a][b], c);
			ans[a][b] = b;
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
				if (d[i][j] == 999999999)
					bw.write("0 ");
				else
					bw.write(d[i][j] + " ");
			}
			bw.write("\n");
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (d[i][j] == 0 || d[i][j] == 999999999) {
					bw.write(0 + "\n");
					continue;
				}
				ArrayList<Integer> al = new ArrayList<>();
				int tmp = ans[i][j];
				al.add(i);
				while (tmp != j) {
					al.add(tmp);
					tmp = ans[tmp][j];
				}
				al.add(j);
				bw.write(al.size() + " ");
				for (int k : al)
					bw.write(k + " ");
				bw.write("\n");
			}
		}

		bw.flush();
		bw.close();
	}
}
