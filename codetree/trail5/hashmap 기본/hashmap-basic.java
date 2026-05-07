import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		Map<Integer, Integer> map = new HashMap<>();

		while (n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			int a, b;
			switch (cmd) {
				case "add":
					a = Integer.parseInt(st.nextToken());
					b = Integer.parseInt(st.nextToken());
					map.put(a, b);
					break;
				case "remove":
					a = Integer.parseInt(st.nextToken());
					map.remove(a);
					break;
				case "find":
					a = Integer.parseInt(st.nextToken());
					bw.write(map.containsKey(a) ? map.get(a) + "\n" : "None\n");
			}
		}

		bw.flush();
	}
}
