import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		char[][] a = new char[h][w];
		for (int i = 0; i < h; i++)
			a[i] = br.readLine().toCharArray();

		int[][] ans = new int[h][w];
		for (int i = 0; i < h; i++) {
			Arrays.fill(ans[i], -1);
		}

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (a[i][j] == 'c') {
					ans[i][j] = 0;
					int nx = j + 1;
					while (nx < w && a[i][nx] != 'c') {
						ans[i][nx] = ans[i][nx - 1] + 1;
						nx++;
					}
				}
			}
		}

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				bw.write(ans[i][j] + " ");
			}
			bw.write("\n");
		}

		bw.flush();
	}
}
