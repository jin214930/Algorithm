import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();
		s += "+";

		int ans = 0;
		boolean flag = false;
		StringBuilder sb = new StringBuilder();

		for (char c : s.toCharArray()) {
			if (c >= '0' && c <= '9')
				sb.append(c);
			else {
				int n = Integer.parseInt(sb.toString());
				if (flag)
					ans -= n;
				else
					ans += n;
				sb = new StringBuilder();
				if (c == '-')
					flag = true;
			}
		}

		bw.write(ans + "");
		bw.flush();
	}
}