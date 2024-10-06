import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String a = st.nextToken();
		String b = st.nextToken();
		StringBuffer sb = new StringBuffer(a);
		String ra = sb.reverse().toString();
		sb = new StringBuffer(b);
		String rb = sb.reverse().toString();

		System.out.println(Math.max(Integer.parseInt(ra), Integer.parseInt(rb)));

	}
}