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

		int[] d = new int[n];
		d[0] = a[0];
		int ans = d[0];
		for (int i = 1; i < n; i++) {
			d[i] = a[i];
			for (int j = 0; j < i; j++) {
				if (a[i] > a[j])
					d[i] = Math.max(d[i], d[j] + a[i]);
			}
			ans = Math.max(ans, d[i]);
		}

		bw.write(ans + "");
		bw.flush();
		bw.close();
	}
}
