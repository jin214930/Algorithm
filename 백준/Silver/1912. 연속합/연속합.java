import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		int[] d = new int[n];
		Arrays.fill(d, Integer.MIN_VALUE);
		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			d[i] = a[i];
			if (i > 0) {
				d[i] = Math.max(d[i - 1] + a[i], d[i]);
			}

			ans = Math.max(ans, d[i]);
		}

		bw.write(ans + "");

		bw.flush();
	}
}
