import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			String s = br.readLine() + " ";
			Stack<Character> st = new Stack<>();

			for (char c : s.toCharArray()) {
				if (c == ' ') {
					while (!st.isEmpty()) {
						bw.write(st.pop());
					}
					bw.write(c);
				} else
					st.push(c);
			}
			bw.write("\n");
		}

		bw.flush();
	}
}