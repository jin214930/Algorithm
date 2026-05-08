import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int cnt3 = 0, cnt5 = 0;
		for (int i = 0 ; i <10;i++) {
			int x = Integer.parseInt(br.readLine());
			if (x % 3 == 0) {
				cnt3++;
			}
			if (x % 5 == 0) {
				cnt5++;
			}
		}
		
		bw.write(cnt3 + " " + cnt5);

		bw.flush();
	}
}
