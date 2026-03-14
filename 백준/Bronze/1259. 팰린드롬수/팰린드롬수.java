import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String s = br.readLine();
			if (s.equals("0"))
				break;
			StringBuffer sb = new StringBuffer(s);
			if (s.equals(sb.reverse().toString()))
				System.out.println("yes");
			else
				System.out.println("no");
		}

	}
}