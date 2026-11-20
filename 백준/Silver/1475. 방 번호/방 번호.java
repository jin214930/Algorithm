import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] cnt = new int[10];

		while (n != 0) {
			cnt[n % 10]++;
			n /= 10;
		}

		int ans = 0;
		for (int i = 0; i < 9; i++) {
			if (i == 6)
				continue;
			ans = Math.max(ans, cnt[i]);
		}

		ans = Math.max(ans, (cnt[6] + cnt[9] + 1) / 2);

		bw.write(ans + "");

		bw.flush();
	}
}
