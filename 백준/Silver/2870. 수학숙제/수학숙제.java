import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		List<String> list = new ArrayList<>();
		while (n-- > 0) {
			String s = br.readLine();
			StringBuilder sb = new StringBuilder();
			for (char c : s.toCharArray()) {
				if (c >= '0' && c <= '9') {
					sb.append(c);
				} else if (sb.length() > 0) {
					while (sb.length() > 0 && sb.charAt(0) == '0') {
						sb.deleteCharAt(0);
					}

					if (sb.length() == 0)
						list.add("0");
					else
						list.add(sb.toString());
					sb.setLength(0);
				}
			}

			if (sb.length() > 0) {
				while (sb.length() > 0 && sb.charAt(0) == '0') {
					sb.deleteCharAt(0);
				}

				if (sb.length() == 0)
					list.add("0");
				else
					list.add(sb.toString());
			}
		}

		Collections.sort(list, (s1, s2) -> {
			if (s1.length() == s2.length()) {
				return s1.compareTo(s2);
			}
			return s1.length() - s2.length();
		});

		for (String s : list) {
			bw.write(s + "\n");
		}

		bw.flush();
	}
}
