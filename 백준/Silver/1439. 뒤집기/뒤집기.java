import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();

		int cnt0 = 0;
		int cnt1 = 0;

		for (int i = 0; i < s.length(); i++) {
			if (i == 0) {
				if (s.charAt(i) == '0')
					cnt0++;
				else
					cnt1++;
				continue;
			}

			if (s.charAt(i - 1) != s.charAt(i)) {
				if (s.charAt(i) == '0')
					cnt0++;
				else
					cnt1++;
			}
		}

		bw.write(Math.min(cnt0, cnt1) + "");
		bw.flush();
	}
}