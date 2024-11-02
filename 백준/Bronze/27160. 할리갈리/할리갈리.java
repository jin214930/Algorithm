import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		HashMap<String, Integer> mp = new HashMap<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			int x = Integer.parseInt(st.nextToken());
			if (mp.containsKey(s))
				mp.put(s, mp.get(s) + x);
			else
				mp.put(s, x);
		}

		for(int i : mp.values()) {
			if(i == 5) {
				bw.write("YES");
				bw.flush();
				bw.close();
				return;
			}
		}
		
		bw.write("NO");
		bw.flush();
		bw.close();
	}
}