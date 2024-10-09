import java.util.*;
import java.io.*;

public class Main {
	static boolean check(long n) {
		if (n <= 1L)
			return false;

		for (long i = 2L; i * i <= n; i++) {
			if (n % i == 0L)
				return false;
		}

		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			long n = Long.parseLong(br.readLine());
			for (long i = n;; i++) {
				if (check(i)) {
					System.out.println(i);
					break;
				}
			}

		}

	}
}