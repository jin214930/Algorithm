import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		long ans = 0;
		int tmp = 0;
		while (tmp < n) {
			ans += n - tmp;
			tmp = tmp * 10 + 9;
		}

		bw.write(ans + "");

		bw.flush();
	}
}
