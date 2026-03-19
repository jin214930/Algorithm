import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int[] cnt = new int[26];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			cnt[s.charAt(0) - 'a']++;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 26; i++) {
			if (cnt[i] >= 5) {
				sb.append((char)(i + 'a'));
			}
		}

		if (sb.length() == 0)
			bw.write("PREDAJA");
		else
			bw.write(sb.toString());
		bw.flush();
	}
}
