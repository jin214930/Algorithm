import java.io.*;
import java.util.*;

public class Main {
	static List<Integer>[] ans;
	static int[] a;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int k = Integer.parseInt(br.readLine());
		int n = 1;

		ans = new ArrayList[k];
		for (int i = 0; i < k; i++) {
			ans[i] = new ArrayList<>();
			n *= 2;
		}
		n -= 1;

		a = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		go(0, 0, n);

		for (int i = 0; i < k; i++) {
			for (int j : ans[i])
				bw.write(j + " ");
			bw.write("\n");
		}

		bw.flush();
	}

	static void go(int h, int s, int n) {
		ans[h].add(a[s + n / 2]);
		if (n == 1)
			return;
		go(h + 1, s, n / 2);
		go(h + 1, s + n / 2 + 1, n / 2);
	}

}
