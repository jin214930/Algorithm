import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			PriorityQueue<Long> pq = new PriorityQueue<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++)
				pq.add(Long.parseLong(st.nextToken()));

			long ans = 0;
			while (pq.size() > 1) {
				long a = pq.poll();
				long b = pq.poll();
				ans += a + b;
				pq.add(a + b);
			}

			bw.write(ans + "\n");
		}
		bw.flush();
		bw.close();
	}
}
