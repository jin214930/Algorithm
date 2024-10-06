import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			String s = st.nextToken();

			for (int i = 0; i < s.length(); i++) {
				for (int j = 0; j < n; j++)
					System.out.print(s.charAt(i));
			}
			System.out.println();
		}

	}
}