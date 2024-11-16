import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(br.readLine());

		for (int i = 0; i < n && s > 0; i++) {
			int mx_idx = i;
			for (int j = i + 1; j < n && j - i <= s; j++) {
				if (a[j] > a[mx_idx])
					mx_idx = j;
			}

			s -= mx_idx - i;

			for (int j = mx_idx; j > i; j--) {
				int tmp = a[j];
				a[j] = a[j - 1];
				a[j - 1] = tmp;
			}
		}

		for (int i : a)
			bw.write(i + " ");
		bw.flush();
		bw.close();
	}
}
