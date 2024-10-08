import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int ans1 = 0, ans2 = -1;
		for (int i = n; i <= m; i++) {
			boolean flag = false;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					flag = true;
					break;
				}
			}
			if (flag || i == 1)
				continue;
			ans1 += i;
			if (ans2 == -1)
				ans2 = i;
		}
		if (ans1 == 0)
			System.out.println(ans2);
		else {
			System.out.println(ans1);
			System.out.println(ans2);
		}

	}
}