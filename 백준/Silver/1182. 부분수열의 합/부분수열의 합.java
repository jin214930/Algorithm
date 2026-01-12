import java.io.*;
import java.util.*;

public class Main {
	static int n, s, ans;
	static int[] a;

	static void check(int x) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			if ((x & (1 << i)) != 0)
				sum += a[i];
		}

		if (sum == s)
			ans++;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());

		a = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(st.nextToken());

		for (int i = 1; i < (1 << n); i++)
			check(i);

		bw.write(ans + "\n");

		bw.flush();
	}
}