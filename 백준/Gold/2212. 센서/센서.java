import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(a);

		int[] d = new int[n - 1];
		for (int i = 0; i < n - 1; i++)
			d[i] = a[i + 1] - a[i];
		Arrays.sort(d);

		int ans = 0;
		for (int i = 0; i < n - k; i++)
			ans += d[i];

		bw.write(ans + "");
		bw.flush();
		bw.close();
	}
}
