import java.util.*;
import java.io.*;

public class Main {
	public static long a, b, c;
	public static long go(long a, long b) {
		if (b == 1)
			return a % c;

		long tmp = go(a, b / 2);
		tmp = tmp * tmp % c;
		if (b % 2 == 1)
			return tmp * a % c;
		else
			return tmp;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		System.out.println(go(a, b));
	}
}