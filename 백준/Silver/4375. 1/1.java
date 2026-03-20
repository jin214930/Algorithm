import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s;
		while ((s = br.readLine()) != null) {
			int n = Integer.parseInt(s);

			int tmp = 1;
			int ans = 1;
			while (tmp % n != 0) {
				tmp = (tmp * 10 + 1) % n;
				ans++;
			}

			bw.write(ans + "\n");
		}

		bw.flush();
	}
}
