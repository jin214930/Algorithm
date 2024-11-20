import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int x = Integer.parseInt(br.readLine());
		for (int i = 1; i < n; i++)
			pq.add(Integer.parseInt(br.readLine()));

		int ans = 0;
		while (!pq.isEmpty() && pq.peek() >= x) {
			x++;
			pq.add(pq.poll() - 1);
			ans++;
		}

		bw.write(ans + "");
		bw.flush();
		bw.close();
	}
}