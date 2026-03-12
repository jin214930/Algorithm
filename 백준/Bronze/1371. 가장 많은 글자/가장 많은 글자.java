import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] cnt = new int[26];

		String s = "";
		while ((s = br.readLine()) != null) {
			for (char c : s.toCharArray()) {
				if (c >= 'a' && c <= 'z')
					cnt[c - 'a']++;
			}
		}

		int max = 0;
		for (int i = 0; i < 26; i++)
			max = Math.max(max, cnt[i]);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 26; i++) {
			if (cnt[i] == max)
				sb.append((char)(i + 'a'));
		}

		bw.write(sb.toString());

		bw.flush();
	}
}