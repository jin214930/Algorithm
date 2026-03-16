import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>((x1, x2) -> {
			if (Math.abs(x1) == Math.abs(x2))
				return x1 - x2;
			return Math.abs(x1) - Math.abs(x2);
		});

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
	}
}