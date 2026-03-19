import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();

		int[] cnt = new int[26];
		for (char c : s.toCharArray()) {
			cnt[c - 'a']++;
		}

		for (int i = 0; i < 26; i++) {
			bw.write(cnt[i] + " ");
		}

		bw.flush();
	}
}
