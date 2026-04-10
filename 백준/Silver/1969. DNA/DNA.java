import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		String[] a = new String[n];
		for (int i = 0; i < n; i++) {
			a[i] = br.readLine();
		}

		char[] dna = {'A', 'C', 'G', 'T'};
		StringBuilder sb = new StringBuilder();
		int ans = 0;
		for (int i = 0; i < m; i++) {
			int[] cnt = new int[4];
			for (int j = 0; j < n; j++) {
				char c = a[j].charAt(i);
				if (c == 'A')
					cnt[0]++;
				else if (c == 'C')
					cnt[1]++;
				else if (c == 'G')
					cnt[2]++;
				else
					cnt[3]++;
			}

			int max = 0;
			char c = 'A';
			for (int j = 0; j < 4; j++) {
				if (cnt[j] > max) {
					c = dna[j];
					max = cnt[j];
				}
			}
			sb.append(c);
			ans += n - max;
		}

		bw.write(sb.toString() + "\n" + ans);

		bw.flush();
	}
}
