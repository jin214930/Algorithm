import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int ans = 0;
		while (n > 1) {
			if (n % 5 == 0) {
				ans += n / 5;
				break;
			}
			n -= 2;
			ans++;
		}

		if (n == 1)
			bw.write("-1");
		else
			bw.write(ans + "");

		bw.flush();
		bw.close();
	}
}