import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[] a = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++)
				a[i] = Integer.parseInt(st.nextToken());

			long ans = 0;

			int tmp = a[n - 1];
			for (int i = n - 2; i >= 0; i--) {
				if (a[i] < tmp) {
					ans += tmp - a[i];
				} else if (a[i] > tmp) {
					tmp = a[i];
				}
			}
			bw.write(ans + "\n");
		}

		bw.flush();
	}
}