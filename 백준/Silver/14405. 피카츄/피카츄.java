import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();
		int idx = 0;
		while (idx < s.length()) {
			char c = s.charAt(idx);
			boolean flag = true;
			if (c == 'p') {
				if (idx + 2 > s.length() || !s.substring(idx, idx + 2).equals("pi")) {
					flag = false;
				}
				idx += 2;
			} else if (c == 'k') {
				if (idx + 2 > s.length() || !s.substring(idx, idx + 2).equals("ka")) {
					flag = false;
				}
				idx += 2;
			} else if (c == 'c') {
				if (idx + 3 > s.length() || !s.substring(idx, idx + 3).equals("chu")) {
					flag = false;
				}
				idx += 3;
			} else {
				flag = false;
			}

			if (!flag) {
				bw.write("NO");
				bw.flush();
				return;
			}
		}

		bw.write("YES");

		bw.flush();
	}
}
