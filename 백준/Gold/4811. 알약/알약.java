import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long[][] d = new long[31][31];
		for (int i = 0; i < 31; i++) {
			d[0][i] = 1;
		}

		for (int i = 1; i <= 30; i++) {
			for (int j = 0; j <= 30; j++) {
				if (j > 0) {
					d[i][j] += d[i][j - 1];
				}

				if (j < 30) {
					d[i][j] += d[i - 1][j + 1];
				}
			}
		}

		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;

			bw.write(d[n][0] + "\n");
		}

		bw.flush();
	}
}
