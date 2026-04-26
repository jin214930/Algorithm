import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long[] f = new long[1000001];
		long[] g = new long[1000001];

		for (int i = 1; i <= 1000000; i++) {
			for (int j = i; j <= 1000000; j += i) {
				f[j] += i;
			}
		}

		for (int i = 1; i <= 1000000; i++) {
			g[i] = g[i - 1] + f[i];
		}

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());

			bw.write(g[n] + "\n");
		}

		bw.flush();
	}
}
