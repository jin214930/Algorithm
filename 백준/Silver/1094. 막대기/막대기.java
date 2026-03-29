import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int x = Integer.parseInt(br.readLine());
		
		int sum = 64;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(64);

		while (sum > x) {
			int tmp = pq.poll();
			if (sum - tmp / 2 >= x) {
				sum -= tmp / 2;
			} else {
				pq.add(tmp / 2);
			}
			pq.add(tmp / 2);
		}

		bw.write(pq.size() + "");

		bw.flush();
	}
}
