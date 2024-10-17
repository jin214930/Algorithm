import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int ans = 0;
		HashMap<String, Integer> mp = new HashMap<>();
		while (n-- > 0) {
			String s = br.readLine();
			if (s.equals("ENTER"))
				mp = new HashMap<>();
			else {
				if (!mp.containsKey(s)) {
					mp.put(s, 1);
					ans++;
				}
			}
		}

		System.out.println(ans);
	}
}