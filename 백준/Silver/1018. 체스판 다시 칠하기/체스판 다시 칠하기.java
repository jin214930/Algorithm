import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static char[][] a;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new char[n][m];
		for (int i = 0; i < n; i++) {
			a[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < n - 7; i++) {
			for (int j = 0; j < m - 7; j++) {
				go(i, j);
			}
		}

		bw.write(ans + "");

		bw.flush();
	}

	static void go(int y, int x) {
		int cnt = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if ((i + j + y + x) % 2 == 0 && a[i + y][j + x] != 'B')
					cnt++;
				else if ((i + j + y + x) % 2 == 1 && a[i + y][j + x] != 'W')
					cnt++;
			}
		}

		ans = Math.min(ans, Math.min(cnt, 64 - cnt));
	}
}
