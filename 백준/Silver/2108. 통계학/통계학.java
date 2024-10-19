import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		int[] cnt = new int[8001];
		double sum = 0;
		int tmp = 0, mod = 0;
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(br.readLine());
			cnt[a[i] + 4000]++;
			sum += a[i];
		}
		int mx = 0;
		for (int i : cnt)
			mx = Math.max(i, mx);
		Arrays.sort(a);

		System.out.println(Math.round(sum / n));
		System.out.println(a[n / 2]);
		for (int i = 0; i <= 8000; i++) {
			if (tmp == 2)
				break;
			if (cnt[i] == mx) {
				tmp++;
				mod = i - 4000;
			}
		}
		System.out.println(mod);
		System.out.println(a[n - 1] - a[0]);
	}
}