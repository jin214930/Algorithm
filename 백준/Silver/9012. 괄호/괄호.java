import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String s = br.readLine();
			Deque<Character> dq = new ArrayDeque<>();
			for (char c : s.toCharArray()) {
				if (c == '(') {
					dq.add(c);
				} else if (!dq.isEmpty() && dq.peek() == '(') {
					dq.poll();
				} else {
					dq.add(c);
				}
			}

			bw.write((dq.isEmpty() ? "YES\n" : "NO\n"));
		}

		bw.flush();
	}
}
