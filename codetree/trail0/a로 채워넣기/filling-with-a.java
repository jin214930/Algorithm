import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (i == 1 || i == s.length() - 2) {
				bw.write("a");
			} else {
				bw.write(c);
			}
		}

		bw.flush();
	}
}
