import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] cnt = new int[26];
		boolean flag = true;

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			cnt[s.charAt(0) - 'a']++;
		}

		for (int i = 0; i < 26; i++) {
			if (cnt[i] >= 5) {
				flag = false;
				System.out.print((char) (i + 'a'));
			}
		}

		if (flag)
			System.out.println("PREDAJA");
	}
}