import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long n = Long.parseLong(br.readLine());
		int cnt = 0;
		long tmp = 0;
		while (n != tmp) {
			if (tmp == 0) {
				tmp = 1;
				cnt++;
			} else if (tmp * 2 >= n) {
				cnt++;
				break;
			} else {
				tmp *= 2;
				cnt++;
			}
		}

		bw.write(cnt + "");
		bw.flush();
		bw.close();
	}
}