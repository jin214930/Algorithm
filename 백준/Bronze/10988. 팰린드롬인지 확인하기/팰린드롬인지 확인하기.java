import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder(br.readLine());
		String s = sb.toString();
		String t = sb.reverse().toString();

		bw.write(s.equals(t) ? "1" : "0");

		bw.flush();
	}
}
