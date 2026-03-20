import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		String pattern = br.readLine();

		int idx = pattern.indexOf('*');
		String pre = pattern.substring(0, idx);
		String suf = pattern.substring(idx + 1);

		while (n-- > 0) {
			String s = br.readLine();
			if (s.length() < pre.length() + suf.length()) {
				bw.write("NE\n");
				continue;
			}

			if (s.startsWith(pre) && s.endsWith(suf))
				bw.write("DA\n");
			else
				bw.write("NE\n");
		}

		bw.flush();
	}
}
