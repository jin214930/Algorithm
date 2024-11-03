import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		String[][] a = new String[n][2];
		int m = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			a[i][0] = st.nextToken();
			String tmp = "";
			for (int j = 0; j < 7; j++)
				tmp += st.nextToken();
			a[i][1] = tmp;
		}
		while (m-- > 0) {
			String s = br.readLine().replaceAll(" ", "");
			int cnt = 0;
			String ans = "";
			for (int i = 0; i < n; i++) {
				if (a[i][1].substring(0, 3).equals(s)) {
					ans = a[i][0];
					cnt++;
				}
			}
			if (cnt == 0)
				bw.write("!\n");
			else if (cnt == 1)
				bw.write(ans + "\n");
			else
				bw.write("?\n");
		}
		bw.flush();
		bw.close();
	}
}