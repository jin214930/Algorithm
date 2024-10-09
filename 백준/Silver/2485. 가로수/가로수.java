import java.util.*;
import java.io.*;

public class Main {
	static int gcd(int a, int b) {
		if (a > b)
			return gcd(b, a);
		if (a == 0)
			return b;
		return gcd(b % a, a);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n - 1];
		int x = Integer.parseInt(br.readLine());
		for (int i = 0; i < n - 1; i++) {
			a[i] = Integer.parseInt(br.readLine());
			a[i] -= x;
			x = a[i] + x;
		}

		x = gcd(a[0], a[1]);
		for (int i = 2; i < n - 1; i++)
			x = gcd(x, a[i]);

		int ans = 0;
		for (int i = 0; i < n - 1; i++)
			ans += a[i] / x - 1;

		System.out.println(ans);

	}
}