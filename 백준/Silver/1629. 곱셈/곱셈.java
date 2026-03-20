import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		bw.write(go(a, b, c) + "");

		bw.flush();
	}

	static int go(int a, int b, int c) {
		if (b == 1) {
			return a % c;
		}

		int tmp = go(a, b / 2, c);

		long ret = (long)tmp * tmp % c;
		if (b % 2 == 1)
			ret = (ret * a) % c;
		return (int)ret;
	}
}
