import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stk = new Stack<>();

		while (n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			if (s.equals("push"))
				stk.push(Integer.parseInt(st.nextToken()));
			else if (s.equals("pop")) {
				if (stk.isEmpty())
					bw.write("-1\n");
				else
					bw.write(stk.pop() + "\n");
			} else if (s.equals("size"))
				bw.write(stk.size() + "\n");
			else if (s.equals("empty")) {
				if (stk.isEmpty())
					bw.write("1\n");
				else
					bw.write("0\n");
			} else {
				if (stk.isEmpty())
					bw.write("-1\n");
				else
					bw.write(stk.peek() + "\n");
			}
		}

		bw.flush();
		bw.close();
	}
}