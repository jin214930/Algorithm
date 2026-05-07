import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		LinkedList<Integer> list = new LinkedList<>();

		while (n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			int x;
			switch (cmd) {
				case "push_back":
					x = Integer.parseInt(st.nextToken());
					list.addLast(x);
					break;
				case "push_front":
					x = Integer.parseInt(st.nextToken());
					list.addFirst(x);
					break;
				case "pop_front":
					bw.write(list.pollFirst() + "\n");
					break;
				case "pop_back":
					bw.write(list.pollLast() + "\n");
					break;
				case "size":
					bw.write(list.size() + "\n");
					break;
				case "empty":
					bw.write((list.isEmpty() ? 1 : 0) + "\n");
					break;
				case "front":
					bw.write(list.peekFirst() + "\n");
					break;
				case "back":
					bw.write(list.peekLast() + "\n");
					break;
			}
		}

		bw.flush();
	}
}
