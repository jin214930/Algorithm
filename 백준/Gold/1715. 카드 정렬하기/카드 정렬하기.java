import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		while (n-- > 0) {
			pq.add(Integer.parseInt(br.readLine()));
		}

		int ans = 0;
		while (pq.size() != 1) {
			int x1 = pq.poll();
			int x2 = pq.poll();

			ans += x1 + x2;
			pq.add(x1 + x2);
		}

		bw.write(ans + "");

		bw.flush();
	}
}