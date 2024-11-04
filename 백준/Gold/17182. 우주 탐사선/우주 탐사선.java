import java.util.*;
import java.io.*;

public class Main {
	static int[][] d;
	static boolean[] visited;
	static int n, ans = 1000000000;

	static void go(int x, int cnt, int sum) {
		if (cnt == n - 1) {
			ans = Math.min(ans, sum);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			go(i, cnt + 1, sum + d[x][i]);
			visited[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		d = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				d[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++)
					d[j][k] = Math.min(d[j][k], d[j][i] + d[i][k]);
			}
		}

		visited = new boolean[n];
		visited[m] = true;
		go(m, 0, 0);

		bw.write(ans + "");
		bw.flush();
		bw.close();
	}
}