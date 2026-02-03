import java.io.*;
import java.util.*;

public class Main {
	static class Class {
		int s, t;

		public Class(int s, int t) {
			this.s = s;
			this.t = t;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		Class[] classes = new Class[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			classes[i] = new Class(s, t);
		}

		Arrays.sort(classes, (c1, c2) -> {
			if (c1.s == c2.s) {
				return c1.t - c2.t;
			}
			return c1.s - c2.s;
		});

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int ans = 1;
		pq.add(classes[0].t);

		for (int i = 1; i < n; i++) {
			if (pq.peek() <= classes[i].s) {
				pq.poll();
			} else {
				ans++;
			}
			pq.add(classes[i].t);
		}
		
		bw.write(ans + "\n");
		bw.flush();
	}
}