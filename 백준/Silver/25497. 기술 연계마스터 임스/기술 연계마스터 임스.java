import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		Stack<Character> st1 = new Stack<>();
		Stack<Character> st2 = new Stack<>();
		int ans = 0;
		for (char c : s.toCharArray()) {
			if (c >= '1' && c <= '9')
				ans++;
			else if (c == 'S')
				st1.push(c);
			else if (c == 'L')
				st2.push(c);
			else if (c == 'K' && !st1.empty() && st1.peek() == 'S') {
				st1.pop();
				ans++;
			} else if (c == 'R' && !st2.empty() && st2.peek() == 'L') {
				st2.pop();
				ans++;
			} else
				break;
		}

		bw.write(ans + "");
		bw.flush();
		bw.close();
	}
}
