import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<String, Integer> mp = new HashMap<>();
		mp.put("ChongChong", 1);
		while (n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();
			if (mp.containsKey(a))
				mp.put(b, 1);
			if (mp.containsKey(b))
				mp.put(a, 1);
		}

		System.out.println(mp.size());
	}
}