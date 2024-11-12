import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int a[] = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(br.readLine());

		int ans = 0;
		for (int i = n - 2; i >= 0; i--) {
			if (a[i + 1] <= a[i]) {
				ans += a[i] - a[i + 1] + 1;
				a[i] = a[i + 1] - 1;
			}
		}

		bw.write(ans + "");
		bw.flush();
		bw.close();
	}
}