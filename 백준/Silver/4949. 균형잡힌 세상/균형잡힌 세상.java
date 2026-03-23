import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			String s = br.readLine();
			if (s.equals("."))
				break;

			Stack<Character> st = new Stack<>();
			for (char c : s.toCharArray()) {
				if (c == '(' || c == '[') {
					st.add(c);
				} else if (c == ')') {
					if (!st.isEmpty() && st.peek() == '(') {
						st.pop();
					} else {
						st.add(c);
					}
				} else if (c == ']') {
					if (!st.isEmpty() && st.peek() == '[') {
						st.pop();
					} else {
						st.add(c);
					}
				}
			}

			bw.write((st.isEmpty() ? "yes\n" : "no\n"));
		}

		bw.flush();
	}
}
