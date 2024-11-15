import java.util.*;
import java.io.*;

public class Main {
	static int[] dy = { 0, -1, 0, 1 };
	static int[] dx = { 1, 0, -1, 0 };

	static int cal(int y, int x) {
		int tmp = Math.max(Math.abs(y), Math.abs(x));
		int min = (int) Math.pow(2 * tmp - 1, 2) + 1;
		if (y == tmp)
			return min + 7 * tmp - 1 + x;
		if (x == -tmp)
			return min + 5 * tmp - 1 + y;
		if (y == -tmp)
			return min + 3 * tmp - 1 - x;
		return min + tmp - 1 - y;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());
		int[][] a = new int[r2 - r1 + 1][c2 - c1 + 1];
		int mx = 0;
		for (int i = r1; i <= r2; i++) {
			for (int j = c1; j <= c2; j++) {
				a[i - r1][j - c1] = cal(i, j);
				mx = Math.max(mx, (int) (Math.log10(a[i - r1][j - c1]) + 1));
			}
		}

		for (int i = r1; i <= r2; i++) {
			for (int j = c1; j <= c2; j++) {
				int l = (int) (Math.log10(a[i - r1][j - c1]) + 1);
				for (int k = 0; k < mx - l; k++)
					bw.write(" ");
				bw.write(a[i - r1][j - c1] + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}
