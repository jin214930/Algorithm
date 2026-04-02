import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		long x = Integer.parseInt(st.nextToken());
		long y = Integer.parseInt(st.nextToken());
		long z = 100 * y / x;

		if (z >= 99) {
			bw.write("-1");
			bw.flush();
			return;
		}

		long s = 1;
		long e = 1000000000;
		long ans = -1;
		while (s <= e) {
			long m = (s + e) / 2;
			if (100 * (y + m) / (x + m) > z) {
				ans = m;
				e = m - 1;
			} else {
				s = m + 1;
			}
		}

		bw.write(ans + "");

		bw.flush();
	}
}
