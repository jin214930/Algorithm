import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++)
			pq.add(Integer.parseInt(br.readLine()));

		int ans = 0;
		while (pq.size() > 1) {
			int a = pq.poll();
			int b = pq.poll();
			ans += a + b;
			pq.add(a + b);
		}

		bw.write(ans + "");
		bw.flush();
		bw.close();
	}
}
