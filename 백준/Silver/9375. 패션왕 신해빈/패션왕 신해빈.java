import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			HashMap<String, Integer> mp = new HashMap<>();
			int n = Integer.parseInt(br.readLine());

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				String s = st.nextToken();
				if (mp.containsKey(s))
					mp.put(s, mp.get(s) + 1);
				else
					mp.put(s, 1);

			}

			int ans = 1;
			for (int i : mp.values())
				ans *= i + 1;

			System.out.println(ans - 1);
		}

	}
}