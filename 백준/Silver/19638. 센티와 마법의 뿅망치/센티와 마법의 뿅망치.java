import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < n; i++)
			pq.add(Integer.parseInt(br.readLine()));

		int i;
		for (i = 0; i < t; i++) {
			if (pq.peek() < h || pq.peek() == 1)
				break;
			else
				pq.add(pq.poll() / 2);
		}

		if (pq.peek() >= h)
			bw.write("NO\n" + pq.peek());
		else
			bw.write("YES\n" + i);
		bw.flush();
		bw.close();
	}
}
