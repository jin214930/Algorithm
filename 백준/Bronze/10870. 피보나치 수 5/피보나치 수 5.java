import java.util.*;
import java.io.*;

public class Main {
	static long go(long n) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		return go(n - 2) + go(n - 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(go(n));
	}
}