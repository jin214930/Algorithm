import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(br.readLine());

		int ans = 0;
		for (int i = 1; i < n; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (a[j + 1] <= a[j]) {
					ans += (a[j] - a[j + 1] + 1);
					a[j] = a[j + 1] - 1;
				}
			}
		}

		bw.write(ans + "");
		bw.flush();
	}
}