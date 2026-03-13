import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int tmp = ~n + 1;

		String s1 = Integer.toBinaryString(n);
		String s2 = Integer.toBinaryString(tmp);

		while (s1.length() != 32)
			s1 = "0" + s1;
		while (s2.length() != 32)
			s2 = "0" + s2;

		int ans = 0;
		for (int i = 0; i < 32; i++) {
			if (s1.charAt(i) != s2.charAt(i))
				ans++;
		}

		bw.write(ans + "");

		bw.flush();
	}
}