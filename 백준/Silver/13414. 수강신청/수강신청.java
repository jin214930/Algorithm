import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		Set<String> set = new LinkedHashSet<>();
		for (int i = 0; i < l; i++) {
			String s = br.readLine();
			if (set.contains(s)) {
				set.remove(s);
				set.add(s);
			} else
				set.add(s);
		}

		int cnt = 0;
		for (String s : set) {
			cnt++;
			bw.write(s + "\n");
			if (cnt == k)
				break;
		}

		bw.flush();
	}
}