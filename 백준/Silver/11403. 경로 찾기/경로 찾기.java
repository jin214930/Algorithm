import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[][] adj;
	static int[] visited;

	static void dfs(int x) {
		for (int i = 0; i < n; i++) {
			if (visited[i] == 1 || adj[x][i] == 0)
				continue;
			visited[i] = 1;
			dfs(i);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		adj = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				adj[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			visited = new int[n];
			dfs(i);
			for (int j = 0; j < n; j++)
				bw.write(visited[j] + " ");
			bw.write("\n");
		}

		bw.flush();
		bw.close();
	}
}