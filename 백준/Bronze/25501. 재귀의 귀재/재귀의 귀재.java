import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String s = br.readLine();
			int ans = 1, cnt = 0;
			for (int i = 0; i < s.length() / 2; i++) {
				if (s.charAt(i) == s.charAt(s.length() - i - 1))
					cnt++;
				else {
					cnt++;
					ans = 0;
					break;
				}
			}
			if (ans == 1)
				cnt++;

			System.out.println(ans + " " + cnt);
		}

	}
}