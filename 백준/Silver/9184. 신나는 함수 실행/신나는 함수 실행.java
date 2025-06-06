import java.util.*;
import java.io.*;

public class Main {
	static int[][][] d = new int[101][101][101];

	static int w(int a, int b, int c) {
		if (d[a + 50][b + 50][c + 50] != 0)
			return d[a + 50][b + 50][c + 50];
		if (a <= 0 || b <= 0 || c <= 0)
			d[a + 50][b + 50][c + 50] = 1;
		else if (a > 20 || b > 20 || c > 20)
			d[a + 50][b + 50][c + 50] = w(20, 20, 20);
		else if (a < b && b < c)
			d[a + 50][b + 50][c + 50] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
		else
			d[a + 50][b + 50][c + 50] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
		return d[a + 50][b + 50][c + 50];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (a == -1 && b == -1 && c == -1)
				break;
			System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, w(a, b, c));
		}

	}
}