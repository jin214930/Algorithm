import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> minH = new PriorityQueue<>();
		PriorityQueue<Integer> maxH = new PriorityQueue<>(Collections.reverseOrder());

		while (n-- > 0) {
			int x = Integer.parseInt(br.readLine());
			if (minH.size() == maxH.size()) {
				if (maxH.isEmpty())
					maxH.add(x);
				else if (minH.peek() < x) {
					minH.add(x);
					maxH.add(minH.poll());
				} else
					maxH.add(x);
			} else {
				if (maxH.peek() > x) {
					maxH.add(x);
					minH.add(maxH.poll());
				} else
					minH.add(x);
			}

			bw.write(maxH.peek() + "\n");
		}

		bw.flush();
	}
}