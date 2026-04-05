import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();

		int ans = 0;
		for (char c : s.toCharArray()) {
			ans += c - '0';
		}

		bw.write(ans + "");

		bw.flush();
	}
}
