import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Map<Integer, String> map1 = new HashMap<>();
		Map<String, Integer> map2 = new HashMap<>();

		for (int i = 1; i <= n; i++) {
			String s = br.readLine();
			map1.put(i, s);
			map2.put(s, i);
		}

		while (m-- > 0) {
			String s = br.readLine();
			if (s.charAt(0) >= '0' && s.charAt(0) <= '9') {
				bw.write(map1.get(Integer.parseInt(s)) + "\n");
			} else {
				bw.write(map2.get(s) + "\n");
			}
		}

		bw.flush();
	}
}
