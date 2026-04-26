import java.io.*;
import java.util.*;

public class Main {
	static int n, ans;
	static char[][] a;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		a = new char[n][n];
		for (int i = 0; i < n; i++) {
			a[i] = br.readLine().toCharArray();
		}

		check();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != n - 1) {
					swap(i, j, i + 1, j);
					check();
					swap(i, j, i + 1, j);
				}
				if (j != n - 1) {
					swap(i, j, i, j + 1);
					check();
					swap(i, j, i, j + 1);
				}
			}
		}

		bw.write(ans + "");
		bw.flush();
	}

	static void check() {
		for (int i = 0; i < n; i++) {
			int yCnt = 1;
			int xCnt = 1;
			for (int j = 1; j < n; j++) {
				if (a[i][j] == a[i][j - 1]) {
					yCnt++;
				} else {
					ans = Math.max(ans, yCnt);
					yCnt = 1;
				}

				if (a[j][i] == a[j - 1][i]) {
					xCnt++;
				} else {
					ans = Math.max(ans, xCnt);
					xCnt = 1;
				}
			}

			ans = Math.max(ans, Math.max(yCnt, xCnt));
		}
	}

	static void swap(int y1, int x1, int y2, int x2) {
		char tmp = a[y1][x1];
		a[y1][x1] = a[y2][x2];
		a[y2][x2] = tmp;
	}
}
