import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		double[] a = new double[n];
		for (int i = 0; i < n; i++) {
			a[i] = Double.parseDouble(br.readLine());
		}

		double[] d = new double[n];
		d[0] = a[0];
		double ans = d[0];
		for (int i = 1; i < n; i++) {
			d[i] = Math.max(a[i], d[i - 1] * a[i]);
			ans = Math.max(ans, d[i]);
		}

		bw.write(String.format("%.3f", ans));

		bw.flush();
	}
}
