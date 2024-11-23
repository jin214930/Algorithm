import java.util.*;
import java.io.*;

class School {
	int l;
	String s;

	public School(String s, int l) {
		this.s = s;
		this.l = l;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			School[] a = new School[n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String s = st.nextToken();
				int l = Integer.parseInt(st.nextToken());
				a[i] = new School(s, l);
			}

			Arrays.sort(a, (s1, s2) -> Integer.compare(s1.l, s2.l));
			bw.write(a[a.length - 1].s + "\n");
		}

		bw.flush();
		bw.close();
	}
}
