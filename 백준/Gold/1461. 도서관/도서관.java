import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if (tmp > 0)
				pq1.add(tmp);
			else
				pq2.add(tmp * -1);
		}

		int tmp = 0;
		if (pq1.isEmpty())
			tmp = pq2.peek();
		else if (pq2.isEmpty())
			tmp = pq1.peek();
		else
			tmp = Math.max(pq1.peek(), pq2.peek());

		int ans = 0;
		while (!pq1.isEmpty()) {
			ans += pq1.poll() * 2;
			for (int i = 0; i < m - 1; i++) {
				if (pq1.isEmpty())
					break;
				pq1.poll();
			}
		}

		while (!pq2.isEmpty()) {
			ans += pq2.poll() * 2;
			for (int i = 0; i < m - 1; i++) {
				if (pq2.isEmpty())
					break;
				pq2.poll();
			}
		}

		ans -= tmp;
		bw.write(ans + "");
		bw.flush();
		bw.close();
	}
}