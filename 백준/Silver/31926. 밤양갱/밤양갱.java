import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int ans = 10;
		int tmp = 2;
		int cnt = 0;
		while (tmp <= n) {
			tmp *= 2;
			cnt++;
		}
		ans += cnt;

		bw.write(ans + "");
		bw.flush();
		bw.close();
	}
}
