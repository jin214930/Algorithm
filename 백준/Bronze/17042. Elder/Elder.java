import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();
		int n = Integer.parseInt(br.readLine());

		Set<String> set = new HashSet<>();
		set.add(s);
		while (n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();

			if (b.equals(s)) {
				set.add(a);
				s = a;
			}
		}

		bw.write(s + "\n");
		bw.write(set.size() + "");

		bw.flush();
	}
}