import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		
		if (a == 0) {
			if (b >= 19) {
				bw.write("MAN");
			} else {
				bw.write("BOY");
			}
		} else {
			if (b >= 19) {
				bw.write("WOMAN");
			} else {
				bw.write("GIRL");
			}
		}

		bw.flush();
	}
}
