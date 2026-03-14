import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] a = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(st.nextToken());
		int ans = 0;
		for (int i = 2; i < n; i++) {
			for (int j = 1; j < i; j++) {
				for (int k = 0; k < j; k++)
					if (a[i] + a[j] + a[k] <= m)
						ans = Math.max(ans, a[i] + a[j] + a[k]);
			}
		}
		System.out.println(ans);
	}
}