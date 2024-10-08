import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == -1)
				break;
			int sum = 0;
			ArrayList<Integer> a = new ArrayList<>();
			for (int i = 2; i < n; i++) {
				if (n % i == 0) {
					sum += i;
					a.add(i);
				}
			}

			if (sum == n - 1) {
				System.out.print(n + " = 1");
				for (int i : a) {
					System.out.print(" + " + i);
				}
				System.out.println();
			} else
				System.out.printf("%d is NOT perfect.\n", n);
		}

	}
}