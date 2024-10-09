import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] p = new int[300001];
		p[1] = 1;
		for (int i = 2; i <= 300000; i++) {
			if (p[i] == 0) {
				for (int j = i * 2; j <= 300000; j += i)
					p[j] = 1;
			}
		}

		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;
			int cnt = 0;
			for (int i = n + 1; i <= 2 * n; i++) {
				if (p[i] == 0)
					cnt++;
			}
			System.out.println(cnt);
		}

	}
}