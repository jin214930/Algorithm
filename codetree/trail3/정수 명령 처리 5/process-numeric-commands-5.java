import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();

		while (n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			int x;

			switch (cmd) {
				case "push_back":
					x = Integer.parseInt(st.nextToken());
					list.add(x);
					break;
				case "pop_back":
					list.remove(list.size() - 1);
					break;
				case "size":
					bw.write(list.size() + "\n");
					break;
				case "get":
					x = Integer.parseInt(st.nextToken());
					bw.write(list.get(x - 1) + "\n");
					break;
			}
		}

		bw.flush();
	}
}
