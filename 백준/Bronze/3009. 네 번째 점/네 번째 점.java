import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] x = new int[3];
		int[] y = new int[3];
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(x);
		Arrays.sort(y);

		if (x[0] == x[1])
			System.out.print(x[2] + " ");
		else
			System.out.print(x[0] + " ");
		if (y[0] == y[1])
			System.out.println(y[2]);
		else
			System.out.println(y[0]);
	}
}