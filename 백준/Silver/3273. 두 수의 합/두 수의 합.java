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
		int x = Integer.parseInt(br.readLine());

		Arrays.sort(a);
		int s = 0, e = n - 1;
		int ans = 0;
		while (s < e) {
			if (a[s] + a[e] == x) {
				ans++;
				s++;
			} else if (a[s] + a[e] < x) {
				s++;
			} else {
				e--;
			}
		}

		bw.write(ans + "");

		bw.flush();
	}
}
