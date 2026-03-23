import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());

			int cnt5 = 0;

			for (int i = 5; i <= n; i *= 5)
				cnt5 += n / i;

			bw.write(cnt5 + "\n");
		}

		bw.flush();
	}
}
