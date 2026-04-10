import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();
		int r = 1, c = s.length();
		for (int i = 1; i * i <= s.length(); i++) {
			if (s.length() % i == 0) {
				r = i;
				c = s.length() / i;
			}
		}

		char[][] a = new char[c][r];
		for (int i = 0; i < s.length(); i++) {
			a[i / r][i % r] = s.charAt(i);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++)
				sb.append(a[j][i]);
		}

		bw.write(sb.toString());

		bw.flush();
	}
}
