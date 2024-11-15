import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[][] a = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			a[i][0] = Integer.parseInt(st.nextToken());
			a[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(a, (o1, o2) -> o1[0] - o2[0]);

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int ans = 0;
		for (int[] i : a) {
			if (pq.isEmpty() || pq.peek() > i[0]) {
				pq.add(i[1]);
				ans = pq.size();
			} else {
				pq.poll();
				pq.add(i[1]);
			}
		}

		bw.write(ans + "");
		bw.flush();
		bw.close();
	}
}
