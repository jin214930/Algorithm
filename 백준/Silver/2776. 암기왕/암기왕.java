import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			Set<Integer> set = new HashSet<>();
			for (int i = 0; i < n; i++) {
				set.add(Integer.parseInt(st.nextToken()));
			}

			int m = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				int x = Integer.parseInt(st.nextToken());
				if (set.contains(x)) {
					bw.write("1\n");
				} else {
					bw.write("0\n");
				}
			}
		}

		bw.flush();
	}
}
