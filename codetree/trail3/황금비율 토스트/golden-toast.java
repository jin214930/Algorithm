import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		LinkedList<Character> list = new LinkedList<>();

		ListIterator<Character> it = list.listIterator();
		String s = br.readLine();
		for (char c : s.toCharArray()) {
			it.add(c);
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();

			if (cmd.equals("L")) {
				if (it.hasPrevious()) {
					it.previous();
				}
			} else if (cmd.equals("R")) {
				if (it.hasNext()) {
					it.next();
				}
			} else if (cmd.equals("D")) {
                if (it.hasNext()) {
					it.next();
                    it.remove();
				}
			} else if (cmd.equals("P")) {
				char c = st.nextToken().charAt(0);
				it.add(c);
			}
		}

		for (char c : list) {
			bw.write(c);
		}

		bw.flush();
	}
}
