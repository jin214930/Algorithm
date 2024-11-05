import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());

		while(t-- > 0) {
			long n = Long.parseLong(br.readLine());
			long s = 1, e = 1000000000, ans = 0;

			while(s <= e) {
				long m = (s + e) / 2;
				long tmp = m * (m + 1) / 2;
				if(tmp <= n) {
					ans = m;
					s = m + 1;
				} else
					e = m - 1;
			}

			bw.write(ans + "\n");
		}


		bw.flush();
		bw.close();
	}
}