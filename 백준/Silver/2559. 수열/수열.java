import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] psum = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			psum[i] = psum[i - 1] + Integer.parseInt(st.nextToken());
		}

		int ans = Integer.MIN_VALUE;
		for (int i = k; i <= n; i++) {
			ans = Math.max(ans, psum[i] - psum[i - k]);
		}

		bw.write(ans + "");

		bw.flush();
	}
}
