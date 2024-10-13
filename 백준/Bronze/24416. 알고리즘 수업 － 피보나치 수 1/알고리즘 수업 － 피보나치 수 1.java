import java.util.*;
import java.io.*;

public class Main {
	static int[] f;
	static int cnt1, cnt2;

	static int fib1(int n) {
		if (n == 1 || n == 2) {
			cnt1++;
			return 1;
		}
		return fib1(n - 1) + fib1(n - 2);
	}

	static int fib2(int n) {
		f[1] = 1;
		f[2] = 1;
		for (int i = 3; i <= n; i++) {
			cnt2++;
			f[i] = f[i - 1] + f[i - 2];
		}
		return f[n];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		f = new int[n + 1];
		fib1(n);
		fib2(n);
		System.out.printf("%d %d", cnt1, cnt2);

	}
}