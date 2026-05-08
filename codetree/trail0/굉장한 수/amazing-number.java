import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		if (n % 3 == 0 && n % 2 == 1 || n % 5 == 0 && n % 2 == 0) {
			bw.write("true");
		} else {
			bw.write("false");
		}

		bw.flush();
	}
}
