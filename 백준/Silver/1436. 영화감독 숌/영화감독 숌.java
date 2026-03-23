import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int cnt = 0;
		for (int i = 666; ; i++) {
			String s = String.valueOf(i);
			if (s.contains("666")) {
				cnt++;
			}

			if (cnt == n) {
				bw.write(i + "");
				break;
			}
		}

		bw.flush();
	}
}
