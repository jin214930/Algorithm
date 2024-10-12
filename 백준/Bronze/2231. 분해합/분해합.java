import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 1; i <= n; i++) {
			int sum = i;
			int tmp = i;
			while (tmp != 0) {
				sum += tmp % 10;
				tmp /= 10;
			}
			if (sum == n) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(0);

	}
}