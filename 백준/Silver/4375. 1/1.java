import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s;
		while ((s = br.readLine()) != null) {
			int x = Integer.parseInt(s);

			int ones = 1;
			int ans = 1;
			while (true) {
				if (ones % x == 0) {
					break;
				}

				ones = (ones * 10 + 1) % x;
				ans++;
			}

			bw.write(ans + "\n");
		}

		bw.flush();
	}
}
