import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int ans = 999999999;
		for (int i = 0; i <= n / 3; i++) {
			int tmp = n - 3 * i;
			if (tmp % 5 == 0)
				ans = Math.min(ans, i + tmp / 5);
		}

		if (ans == 999999999)
			System.out.println(-1);
		else
			System.out.println(ans);
	}
}