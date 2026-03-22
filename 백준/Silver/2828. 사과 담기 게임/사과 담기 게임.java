import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int j = Integer.parseInt(br.readLine());

		int s = 1;
		int e = m;

		int ans = 0;
		while (j-- > 0) {
			int x = Integer.parseInt(br.readLine());
			if (s > x) {
				ans += s - x;
				s = x;
				e = x + m - 1;
			} else if (e < x) {
				ans += x - e;
				e = x;
				s = x - m + 1;
			}
		}

		bw.write(ans + "");

		bw.flush();
	}
}
