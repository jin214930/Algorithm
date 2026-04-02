import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		int[] d = new int[n];
		int[] pre = new int[n];
		Arrays.fill(pre, -1);
		d[0] = 1;
		int ans = 1;
		int tmp = 0;
		for (int i = 1; i < n; i++) {
			d[i] = 1;
			for (int j = 0; j < i; j++) {
				if (a[j] < a[i]) {
					d[i] = Math.max(d[i], d[j] + 1);
					if (d[i] == d[j] + 1) {
						pre[i] = j;
					}
				}
			}
			if (ans < d[i]) {
				ans = d[i];
				tmp = i;
			}
		}

		bw.write(ans + "\n");
		List<Integer> list = new ArrayList<>();
		while (tmp != -1) {
			list.add(a[tmp]);
			tmp = pre[tmp];
		}

		for (int i = list.size() - 1; i >= 0; i--) {
			bw.write(list.get(i) + " ");
		}

		bw.flush();
	}
}
