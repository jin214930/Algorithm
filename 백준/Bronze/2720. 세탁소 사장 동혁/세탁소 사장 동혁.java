import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[] a = { 25, 10, 5, 1 };
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			for (int i : a) {
				System.out.print(n / i + " ");
				n %= i;
			}
			System.out.println();
		}
	}
}