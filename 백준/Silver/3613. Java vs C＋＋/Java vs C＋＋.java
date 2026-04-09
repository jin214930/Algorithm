import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();

		boolean isJava = false;
		boolean isC = false;
		for (char c : s.toCharArray()) {
			if (c == '_') {
				isC = true;
			} else if (c >= 'A' && c <= 'Z') {
				isJava = true;
			}
		}

		if ((isC && isJava) || (s.charAt(0) >= 'A' && s.charAt(0) <= 'Z') || s.startsWith("_") || s.endsWith("_")
			|| s.contains("__")) {
			bw.write("Error!");
			bw.flush();
			return;
		}

		if (isC) {
			for (int i = 0; i < 26; i++) {
				s = s.replaceAll("_" + (char)(i + 'a'), Character.toString((char)(i + 'A')));
			}
		} else {
			for (int i = 0; i < 26; i++) {
				s = s.replaceAll(Character.toString((char)(i + 'A')), "_" + (char)(i + 'a'));
			}
		}

		bw.write(s);

		bw.flush();
	}
}
