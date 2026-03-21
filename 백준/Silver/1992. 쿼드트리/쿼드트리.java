import java.io.*;
import java.util.*;

public class Main {
	static char[][] a;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		a = new char[n][n];
		for (int i = 0; i < n; i++) {
			a[i] = br.readLine().toCharArray();
		}

		bw.write(go(0, 0, n));

		bw.flush();
	}

	static String go(int y, int x, int n) {
		char tmp = a[y][x];
		for (int i = y; i < y + n; i++) {
			for (int j = x; j < x + n; j++) {
				if (tmp != a[i][j]) {
					String ret = "(";
					ret += go(y, x, n / 2);
					ret += go(y, x + n / 2, n / 2);
					ret += go(y + n / 2, x, n / 2);
					ret += go(y + n / 2, x + n / 2, n / 2);
					ret += ")";
					return ret;
				}
			}
		}

		return String.valueOf(tmp);
	}
}
