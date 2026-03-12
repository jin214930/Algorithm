import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String s = br.readLine();

			int sum = 0;
			for (int i = 0; i < s.length(); i++) {
				if (i % 2 == 0) {
					int tmp = (s.charAt(i) - '0') * 2;
					if (tmp >= 10) {
						tmp = tmp / 10 + tmp % 10;
					}

					sum += tmp;
				} else
					sum += s.charAt(i) - '0';
			}

			if (sum % 10 == 0)
				bw.write("T\n");
			else
				bw.write("F\n");
		}

		bw.flush();
	}
}