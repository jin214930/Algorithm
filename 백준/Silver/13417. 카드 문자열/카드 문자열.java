import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			Deque<Character> dq = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			dq.addFirst(st.nextToken().charAt(0));
			for (int i = 0; i < n - 1; i++) {
				char c = st.nextToken().charAt(0);
				if (c <= dq.peekFirst())
					dq.addFirst(c);
				else
					dq.addLast(c);
			}

			for (char c : dq)
				bw.write(c);
			bw.write("\n");
		}

		bw.flush();
		bw.close();
	}
}