import java.util.*;
import java.io.*;

public class Main {
	static int gcd(int a, int b) {
		if (a > b)
			return gcd(b, a);
		if (a == 0)
			return b;
		return gcd(b % a, a);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int x = b * d / gcd(b, d);
		int y = x / b * a + x / d * c;
		int tmp = gcd(x, y);
		System.out.println(y / tmp);
		System.out.println(x / tmp);
	}
}