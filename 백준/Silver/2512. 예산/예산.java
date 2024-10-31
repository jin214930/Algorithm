import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = 1, e = 0, ans = 0;
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			e = Math.max(a[i], e);
		}
		int m = Integer.parseInt(br.readLine());
		while (s <= e) {
			int mid = (s + e) / 2;
			int sum = 0;
			for (int i : a)
				sum += Math.min(mid, i);
			if (sum <= m) {
				ans = mid;
				s = mid + 1;
			} else
				e = mid - 1;
		}
		System.out.println(ans);
	}
}