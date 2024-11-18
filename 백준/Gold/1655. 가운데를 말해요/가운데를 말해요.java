import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> mnh = new PriorityQueue<>();
		PriorityQueue<Integer> mxh = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			if (mxh.size() == mnh.size()) {
				if (mxh.isEmpty())
					mxh.add(x);
				else {
					if (mnh.peek() < x) {
						mxh.add(mnh.poll());
						mnh.add(x);
					} else
						mxh.add(x);
				}
			} else if (mxh.size() > mnh.size()) {
				if (mxh.peek() > x) {
					mnh.add(mxh.poll());
					mxh.add(x);
				} else
					mnh.add(x);
			}

			bw.write(mxh.peek() + "\n");
		}

		bw.flush();
		bw.close();
	}
}
