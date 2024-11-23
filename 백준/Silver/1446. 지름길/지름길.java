import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int[][] a = new int[n][3];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++)
				a[i][j] = Integer.parseInt(st.nextToken());
		}

		int[] dist = new int[d + 1];
		for (int i = 0; i <= d; i++)
			dist[i] = i;

		for (int i = 1; i <= d; i++) {
			dist[i] = Math.min(dist[i], dist[i - 1] + 1);
			for (int j = 0; j < n; j++) {
				if (a[j][1] == i)
					dist[i] = Math.min(dist[i], dist[a[j][0]] + a[j][2]);
			}
		}

		bw.write(dist[d] + "");
		bw.flush();
		bw.close();
	}
}
