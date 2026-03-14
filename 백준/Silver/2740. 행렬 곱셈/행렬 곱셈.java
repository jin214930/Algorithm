import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] a = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++)
				a[i][j] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] b = new int[m][k];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < k; j++)
				b[i][j] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < k; j++) {
				int tmp = 0;
				for (int l = 0; l < m; l++)
					tmp += a[i][l] * b[l][j];
				System.out.print(tmp + " ");
			}
			System.out.println();
		}

	}
}