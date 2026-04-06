import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static String s;
	static int ans = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		s = br.readLine();

		go(2, s.charAt(0) - '0');

		bw.write(ans + "");

		bw.flush();
	}

	static void go(int idx, int sum) {
		if (idx >= n) {
			ans = Math.max(ans, sum);
			return;
		}

		go(idx + 2, eval(sum, s.charAt(idx) - '0', s.charAt(idx - 1)));
		if (idx + 2 < n) {
			go(idx + 4,
				eval(sum, eval(s.charAt(idx) - '0', s.charAt(idx + 2) - '0', s.charAt(idx + 1)), s.charAt(idx - 1)));
		}

	}

	static int eval(int n1, int n2, char op) {
		if (op == '+')
			return n1 + n2;
		else if (op == '-')
			return n1 - n2;
		return n1 * n2;
	}
}
