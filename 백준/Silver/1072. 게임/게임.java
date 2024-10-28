import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int z = (int) (y * 100L / x);
		int ans = -1;
		int s = 1, e = 1000000000;
		while (s <= e) {
			int m = (s + e) / 2;
			int tmp = (int) ((y + m) * 100L / (x + m));
			if (z < tmp) {
				ans = m;
				e = m - 1;
			} else
				s = m + 1;
		}
		System.out.println(ans);
	}
}