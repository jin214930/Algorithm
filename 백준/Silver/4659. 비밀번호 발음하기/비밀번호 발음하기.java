import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			String s = br.readLine();
			if (s.equals("end"))
				break;

			boolean hasVowel = false;
			for (char c : s.toCharArray()) {
				if (isVowel(c)) {
					hasVowel = true;
					break;
				}
			}

			boolean flag = !hasVowel;

			if (s.length() >= 2) {
				for (int i = 1; i < s.length(); i++) {
					if (s.charAt(i) == s.charAt(i - 1) && s.charAt(i) != 'e' && s.charAt(i) != 'o') {
						flag = true;
						break;
					}
				}
			}

			if (s.length() >= 3) {
				for (int i = 0; i < s.length() - 2; i++) {
					String tmp = s.substring(i, i + 3);
					char c1 = tmp.charAt(0);
					char c2 = tmp.charAt(1);
					char c3 = tmp.charAt(2);
					if ((isVowel(c1) && isVowel(c2) && isVowel(c3)) || (!isVowel(c1) && !isVowel(c2) && !isVowel(c3))) {
						flag = true;
						break;
					}
				}
			}

			String ans = flag ? "<%s> is not acceptable.\n" : "<%s> is acceptable.\n";
			bw.write(String.format(ans, s));
		}

		bw.flush();
	}

	static boolean isVowel(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}
}
