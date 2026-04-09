import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();

		int ans = 0;
		int idx = 0;
		while (idx < s.length()) {
			char c = s.charAt(idx);
			if (c == 'c') {
				if (idx < s.length() - 1 && (s.charAt(idx + 1) == '=' || s.charAt(idx + 1) == '-')) {
					idx += 1;
				}
			} else if (c == 'd') {
				if (idx < s.length() - 1 && s.charAt(idx + 1) == '-') {
					idx += 1;
				} else if (idx < s.length() - 2 && s.charAt(idx + 1) == 'z' && s.charAt(idx + 2) == '=') {
					idx += 2;
				}
			} else if (c == 'l') {
				if (idx < s.length() - 1 && s.charAt(idx + 1) == 'j') {
					idx += 1;
				}
			} else if (c == 'n') {
				if (idx < s.length() - 1 && s.charAt(idx + 1) == 'j') {
					idx += 1;
				}
			} else if (c == 's') {
				if (idx < s.length() - 1 && s.charAt(idx + 1) == '=') {
					idx += 1;
				}
			} else if (c == 'z') {
				if (idx < s.length() - 1 && s.charAt(idx + 1) == '=') {
					idx += 1;
				}
			}
			idx++;
			ans++;
		}

		bw.write(ans + "");

		bw.flush();
	}
}
