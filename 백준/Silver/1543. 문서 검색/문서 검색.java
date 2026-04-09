import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();
		String t = br.readLine();

		if (s.length() < t.length()) {
			bw.write("0");
			bw.flush();
			return;
		}

		int idx = 0;
		int ans = 0;
		while (idx <= s.length() - t.length()) {
			if (s.substring(idx, idx + t.length()).equals(t)) {
				ans++;
				idx += t.length();
			} else {
				idx++;
			}
		}

		bw.write(ans + "");

		bw.flush();
	}
}
