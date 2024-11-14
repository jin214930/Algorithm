import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		int ans1 = 0, ans2 = 0;
		while (n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			if (x == 1) {
				int y = Integer.parseInt(st.nextToken());
				q.add(y);
				if (ans1 < q.size()) {
					ans1 = q.size();
					ans2 = y;
				} else if (ans1 == q.size() && y < ans2)
					ans2 = y;
			} else
				q.poll();
		}

		bw.write(ans1 + " " + ans2);
		bw.flush();
		bw.close();
	}
}
