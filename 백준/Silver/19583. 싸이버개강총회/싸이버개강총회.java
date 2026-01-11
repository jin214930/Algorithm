import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		String s = st.nextToken();
		String e = st.nextToken();
		String q = st.nextToken();

		Set<String> set = new HashSet<>();

		int ans = 0;
		while (true) {
			String line = br.readLine();

			if (line == null)
				break;

			st = new StringTokenizer(line);
			String t = st.nextToken();
			String name = st.nextToken();

			if (t.compareTo(s) <= 0)
				set.add(name);
			else if (t.compareTo(e) >= 0 && t.compareTo(q) <= 0) {
				if (set.contains(name))
					ans++;
				set.remove(name);
			}
		}

		bw.write(ans + "");
		bw.flush();
	}
}