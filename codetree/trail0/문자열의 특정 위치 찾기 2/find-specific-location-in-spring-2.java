import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		char c = br.readLine().charAt(0);

		int cnt = 0;
		for (String s : new String[] {"apple", "banana", "grape", "blueberry", "orange"}) {
			if (c == s.charAt(2) || c == s.charAt(3)) {
				cnt++;
				bw.write(s + "\n");
			}
		}
		bw.write(cnt + "");

		bw.flush();
	}
}
