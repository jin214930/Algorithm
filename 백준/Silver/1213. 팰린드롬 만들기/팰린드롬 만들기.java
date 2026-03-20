import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();
		int[] cnt = new int[26];
		for (char c : s.toCharArray()) {
			cnt[c - 'A']++;
		}

		boolean flag = false;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 26; i++) {
			if (cnt[i] % 2 == 1) {
				if (flag) {
					bw.write("I'm Sorry Hansoo");
					bw.flush();
					return;
				}

				sb.append((char)(i + 'A'));
				cnt[i]--;
				flag = true;
			}
		}

		for (int i = 25; i >= 0; i--) {
			for (int j = 0; j < cnt[i] / 2; j++) {
				sb.append((char)(i + 'A'));
				sb.insert(0, (char)(i + 'A'));
			}
		}

		bw.write(sb.toString());

		bw.flush();
	}
}
