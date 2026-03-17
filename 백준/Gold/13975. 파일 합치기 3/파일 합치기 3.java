import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());

			PriorityQueue<Long> pq = new PriorityQueue<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			while (n-- > 0) {
				pq.add(Long.parseLong(st.nextToken()));
			}

			long ans = 0;
			while (pq.size() != 1) {
				long x1 = pq.poll();
				long x2 = pq.poll();
				ans += x1 + x2;
				pq.add(x1 + x2);
			}

			bw.write(ans + "\n");
		}

		bw.flush();
	}
}