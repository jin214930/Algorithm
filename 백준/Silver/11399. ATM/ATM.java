import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(a);

		int ans = 0;
		int tmp = 0;
		for (int i = 0; i < n; i++) {
			ans += tmp + a[i];
			tmp += a[i];
		}

		bw.write(ans + "\n");
		bw.flush();
	}
}