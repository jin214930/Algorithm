import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int m = Integer.parseInt(br.readLine());
		Set<Integer> set = new HashSet<>();

		while (m-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();

			if (s.equals("all")) {
				for (int i = 1; i <= 20; i++) {
					set.add(i);
				}
			} else if (s.equals("empty")) {
				set = new HashSet<>();
			} else {
				int x = Integer.parseInt(st.nextToken());
				if (s.equals("add")) {
					set.add(x);
				} else if (s.equals("remove")) {
					set.remove(x);
				} else if (s.equals("check")) {
					bw.write(set.contains(x) ? "1\n" : "0\n");
				} else if (s.equals("toggle")) {
					if (set.contains(x)) {
						set.remove(x);
					} else {
						set.add(x);
					}
				}
			}
		}

		bw.flush();
	}
}
