import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			map.put(s, map.getOrDefault(s, 0) + 1);
		}

		int ans = 0;
		for (int i : map.values()) {
			ans = Math.max(ans, i);
		}

		bw.write(ans + "");
		bw.flush();
	}
}
