import java.util.*;
import java.io.*;

public class Main {
	static int n, ans;
	static int[] a;
	static boolean[] visited, finish;

	static void dfs(int x) {
		visited[x] = true;
		int nx = a[x];
		if (!visited[nx])
			dfs(nx);
		else if (!finish[nx]) {
			int tx = x;
			while (true) {
				ans--;
				tx = a[tx];
				if (tx == x)
					break;
			}
		}
		finish[x] = true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = new int[n + 1];
			for (int i = 1; i <= n; i++)
				a[i] = Integer.parseInt(st.nextToken());

			visited = new boolean[n + 1];
			finish = new boolean[n + 1];
			ans = n;
			for (int i = 1; i <= n; i++) {
				if (!visited[i]) {

					dfs(i);
				}
			}
			bw.write(ans + "\n");
		}

		bw.flush();
		bw.close();
	}
}