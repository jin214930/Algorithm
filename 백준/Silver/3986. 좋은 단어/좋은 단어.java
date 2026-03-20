import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int ans = 0;
		while (n-- > 0) {
			String s = br.readLine();
			Deque<Character> st = new ArrayDeque<>();

			for (char c : s.toCharArray()) {
				if (!st.isEmpty() && st.peek() == c) {
					st.pop();
				} else
					st.push(c);
			}

			if (st.isEmpty())
				ans++;
		}

		bw.write(ans + "");
		bw.flush();
	}
}
