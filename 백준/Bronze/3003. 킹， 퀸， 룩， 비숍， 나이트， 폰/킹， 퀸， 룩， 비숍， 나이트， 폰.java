import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] a = { 1, 1, 2, 2, 2, 8 };
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 6; i++) {
			int n = Integer.parseInt(st.nextToken());
			System.out.printf("%d ", a[i] - n);
		}
	}
}