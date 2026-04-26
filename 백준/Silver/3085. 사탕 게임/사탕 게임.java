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

		go();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != n - 1) {
					char tmp = a[i][j];
					a[i][j] = a[i + 1][j];
					a[i + 1][j] = tmp;
					go();
					tmp = a[i][j];
					a[i][j] = a[i + 1][j];
					a[i + 1][j] = tmp;
				}
				if (j != n - 1) {
					char tmp = a[i][j];
					a[i][j] = a[i][j + 1];
					a[i][j + 1] = tmp;
					go();
					tmp = a[i][j];
					a[i][j] = a[i][j + 1];
					a[i][j + 1] = tmp;
				}
			}
		}

		bw.write(ans + "");
		bw.flush();
	}

	static void go() {
		int ret = 0;
		for (int i = 0; i < n; i++) {
			char tmp = '\0';
			int cnt = 0;
			for (int j = 0; j < n; j++) {
				if (tmp == a[i][j]) {
					cnt++;
				} else {
					ret = Math.max(ret, cnt);
					cnt = 1;
					tmp = a[i][j];
				}

				if (j == n - 1) {
					tmp = '\0';
					ret = Math.max(ret, cnt);
				}
			}
		}

		for (int i = 0; i < n; i++) {
			char tmp = '\0';
			int cnt = 0;
			for (int j = 0; j < n; j++) {
				if (tmp == a[j][i]) {
					cnt++;
				} else {
					ret = Math.max(ret, cnt);
					cnt = 1;
					tmp = a[j][i];
				}

				if (j == n - 1) {
					tmp = '\0';
					ret = Math.max(ret, cnt);
				}
			}
		}

		ans = Math.max(ans, ret);
	}
}
