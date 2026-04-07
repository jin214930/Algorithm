import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();

		List<String> list = new ArrayList<>();
		for (int i = 1; i < s.length() - 1; i++) {
			for (int j = i + 1; j < s.length(); j++) {
				StringBuilder sb = new StringBuilder();
				for (int k = i - 1; k >= 0; k--) {
					sb.append(s.charAt(k));
				}

				for (int k = j - 1; k >= i; k--) {
					sb.append(s.charAt(k));
				}

				for (int k = s.length() - 1; k >= j; k--) {
					sb.append(s.charAt(k));
				}

				list.add(sb.toString());
			}
		}

		Collections.sort(list);

		bw.write(list.get(0));

		bw.flush();
	}
}
