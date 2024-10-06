import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int ans = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c <= 'C')
				ans += 3;
			else if (c <= 'F')
				ans += 4;
			else if (c <= 'I')
				ans += 5;
			else if (c <= 'L')
				ans += 6;
			else if (c <= 'O')
				ans += 7;
			else if (c <= 'S')
				ans += 8;
			else if (c <= 'V')
				ans += 9;
			else
				ans += 10;
		}
		System.out.println(ans);
	}
}