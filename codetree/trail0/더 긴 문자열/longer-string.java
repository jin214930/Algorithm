import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		String a = st.nextToken();
		String b = st.nextToken();

		if (a.length() > b.length()) {
			bw.write(a + " " + a.length());
		} else if (a.length() < b.length()) {
			bw.write(b + " " + b.length());
		} else {
			bw.write("same");
		}

		bw.flush();
	}
}
