import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			int cnt = 0;
			String s = br.readLine();
			if (s.equals("#"))
				break;
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
						|| c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
					cnt++;
			}
			System.out.println(cnt);
		}

	}
}