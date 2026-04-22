import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();

		Stack<Character> st = new Stack<>();
		boolean flag = false;
		for (char c : s.toCharArray()) {
			if (flag) {
				if (c == '>')
					flag = false;
				bw.write(c);
				continue;
			}

			if (c == '<' || c == ' ') {
				while (!st.isEmpty()) {
					bw.write(st.pop());
				}
				if (c == '<') {
					flag = true;
				}
				bw.write(c);
				continue;
			}

			st.push(c);
		}

		while (!st.isEmpty()) {
			bw.write(st.pop());
		}

		bw.flush();
	}
}
