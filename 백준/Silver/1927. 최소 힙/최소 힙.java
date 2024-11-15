import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		while (n-- > 0) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0) {
				if (pq.isEmpty())
					bw.write("0\n");
				else
					bw.write(pq.poll() + "\n");
			} else
				pq.add(x);
		}
		bw.flush();
		bw.close();
	}
}
