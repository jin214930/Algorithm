import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				for (int j = 1; j <= n; j++) {
					bw.write(j + "");
				}
			} else {
				for (int j = n; j >= 1; j--) {
					bw.write(j + "");
				}
			}
			bw.write("\n");
		}

		bw.flush();
	}
}
