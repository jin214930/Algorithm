import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		if (n < 1000) {
			bw.write("no");
		} else if (n >= 3000) {
			bw.write("book");
		} else {
			bw.write("mask");
		}

		bw.flush();
	}
}
