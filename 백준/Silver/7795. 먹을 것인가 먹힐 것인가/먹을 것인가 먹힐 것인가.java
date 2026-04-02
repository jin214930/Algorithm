import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			PriorityQueue<Integer> pq = new PriorityQueue<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				pq.add(Integer.parseInt(st.nextToken()));
			}

			int[] b = new int[m];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(b);

			int ans = 0;

			for (int i = 0; i < m; i++) {
				while (!pq.isEmpty() && pq.peek() <= b[i]) {
					pq.poll();
				}
				ans += pq.size();
			}

			bw.write(ans + "\n");
		}

		bw.flush();
	}
}
