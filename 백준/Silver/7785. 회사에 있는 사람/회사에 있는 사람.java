import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		HashSet<String> s = new HashSet<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();
			if (b.equals("enter"))
				s.add(a);
			else
				s.remove(a);
		}

		String[] ans = s.toArray(new String[0]);
		Arrays.sort(ans, Comparator.reverseOrder());
		for (String i : ans)
			bw.write(i + "\n");

		bw.flush();
		bw.close();
	}
}