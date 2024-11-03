import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashMap<String, String> mp = new HashMap<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			String tmp = "";
			for (int j = 0; j < 7; j++)
				tmp += st.nextToken();
			mp.put(tmp, s);
		}

		while (m-- > 0) {
			String s = br.readLine().replaceAll(" ", "");
			int cnt = 0;
			String tmp = "";
			for (String i : mp.keySet()) {
				if (i.substring(0, 3).equals(s)) {
					tmp = i;
					cnt++;
				}
			}
			if (cnt == 0)
				bw.write("!\n");
			else if (cnt == 1)
				bw.write(mp.get(tmp) + "\n");
			else
				bw.write("?\n");
		}

		bw.flush();
		bw.close();
	}
}