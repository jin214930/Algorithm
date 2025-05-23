import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] a = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(st.nextToken());
		int s = 0, e = 1000000000, ans = 0;
		while (s <= e) {
			int mid = (s + e) / 2;
			long sum = 0;
			for (int i : a)
				sum += Math.max(0, i - mid);
			if (sum >= m) {
				ans = mid;
				s = mid + 1;
			} else
				e = mid - 1;
		}
		bw.write(ans + "");
		bw.flush();
		bw.close();
	}
}