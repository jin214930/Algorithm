import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());

		int[] a = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(st.nextToken());

		int[] d1 = new int[n];
		d1[0] = 1;
		for (int i = 1; i < n; i++) {
			d1[i] = 1;
			for (int j = 0; j < i; j++) {
				if (a[j] < a[i])
					d1[i] = Math.max(d1[i], d1[j] + 1);
			}
		}

		int[] d2 = new int[n];
		d2[n - 1] = 1;
		for (int i = n - 2; i >= 0; i--) {
			d2[i] = 1;
			for (int j = i + 1; j < n; j++) {
				if (a[i] > a[j])
					d2[i] = Math.max(d2[i], d2[j] + 1);
			}
		}

		int ans = 0;
		for (int i = 0; i < n; i++)
			ans = Math.max(ans, d1[i] + d2[i] - 1);

		bw.write(ans + "");
		bw.flush();
		bw.close();
	}
}
