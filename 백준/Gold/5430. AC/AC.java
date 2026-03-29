import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");
			Deque<Integer> dq = new ArrayDeque<>();
			boolean isReverse = false;
			for (int i = 0; i < n; i++) {
				dq.addLast(Integer.parseInt(st.nextToken()));
			}

			boolean isError = false;
			for (char c : p.toCharArray()) {
				if (c == 'R') {
					isReverse = !isReverse;
				} else if (dq.isEmpty()) {
					isError = true;
					break;
				} else if (isReverse) {
					dq.pollLast();
				} else {
					dq.pollFirst();
				}
			}

			if (isError) {
				bw.write("error\n");
				continue;
			}

			StringBuilder sb = new StringBuilder();
			sb.append("[");
			if (isReverse) {
				while (!dq.isEmpty()) {
					sb.append(dq.pollLast());
					if (!dq.isEmpty()) {
						sb.append(",");
					}
				}
			} else {
				while (!dq.isEmpty()) {
					sb.append(dq.pollFirst());
					if (!dq.isEmpty()) {
						sb.append(",");
					}
				}
			}

			sb.append("]\n");
			bw.write(sb.toString());

		}

		bw.flush();
	}
}
