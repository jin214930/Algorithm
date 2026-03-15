import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int ans = Integer.MAX_VALUE;
		if (n < 4)
			n = 4;

		for (int i = 2; i * i <= n; i++) {
			int x = n / i + (n % i == 0 ? 0 : 1);
			ans = Math.min(ans, (x + i - 2) * 2);
		}

		bw.write(ans + "");

		bw.flush();
	}
}