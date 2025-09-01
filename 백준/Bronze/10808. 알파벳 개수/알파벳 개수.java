import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int[] cnt = new int[26];

		for (int i = 0; i < s.length(); i++)
			cnt[s.charAt(i) - 'a']++;
		for (int i = 0; i < 26; i++)
			System.out.print(cnt[i] + " ");
	}
}