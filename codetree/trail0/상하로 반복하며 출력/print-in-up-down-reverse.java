import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[][] a = new int[n][n];
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < n; j++) {
					a[j][i] = j + 1;

				}
			} else {
				for (int j = 0; j < n; j++) {
					a[j][i] = n - j;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				bw.write(a[i][j] + "");
			}
			bw.write("\n");
		}

		bw.flush();
	}
}
