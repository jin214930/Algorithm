import java.io.*;
import java.util.*;

public class Main {
	static boolean[][] map;
	static int n, m, h;
	static int ans = 4;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		map = new boolean[h + 1][n + 1];
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = true;
		}

		go(1, 0);

		bw.write((ans == 4 ? -1 : ans) + "");
		bw.flush();
	}

	static void go(int here, int cnt) {
		if (cnt > 3 || cnt >= ans)
			return;

		if (check()) {
			ans = cnt;
			return;
		}

		for (int i = here; i <= h; i++) {
			for (int j = 1; j < n; j++) {
				if (!map[i][j] && !map[i][j - 1] && !map[i][j + 1]) {
					map[i][j] = true;
					go(i, cnt + 1);
					map[i][j] = false;
				}
			}
		}
	}

	static boolean check() {
		for (int i = 1; i <= n; i++) {
			int tmp = i;
			for (int j = 1; j <= h; j++) {
				if (map[j][tmp]) {
					tmp++;
				} else if (tmp > 1 && map[j][tmp - 1]) {
					tmp--;
				}
			}
			if (tmp != i)
				return false;
		}
		return true;
	}
}
