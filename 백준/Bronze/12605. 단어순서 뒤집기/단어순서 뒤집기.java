import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Stack<String> stk = new Stack<>();
			while (st.hasMoreTokens())
				stk.push(st.nextToken());

			bw.write("Case #" + i + ": ");
			while (!stk.isEmpty())
				bw.write(stk.pop() + " ");
			bw.write("\n");
		}

		bw.flush();
		bw.close();
	}
}