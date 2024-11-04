import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		HashMap<String, Integer> mp = new HashMap<>();

		for (int i = 0; i < n; i++) {
			int[] t = { 4, 6, 4, 10 };
			for (int j = 0; j < 4; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 7; k++) {
					String s = st.nextToken();
					if (s.equals("-"))
						continue;
					if (mp.containsKey(s))
						mp.put(s, mp.get(s) + t[j]);
					else
						mp.put(s, t[j]);
				}
			}
		}

		if (mp.isEmpty()) {
			bw.write("Yes");
			bw.flush();
			bw.close();
			return;
		}

		for (int i : mp.values()) {
			for (int j : mp.values()) {
				if (Math.abs(i - j) > 12) {
					bw.write("No");
					bw.flush();
					bw.close();
					return;
				}
			}
		}

		bw.write("Yes");
		bw.flush();
		bw.close();
	}
}