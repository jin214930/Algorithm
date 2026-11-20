import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		boolean[] check = new boolean[1000001];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(st.nextToken());
			check[x] = true;
		}

		int x = Integer.parseInt(br.readLine());

		int ans = 0;
		for (int i = 1; i <= (x - 1) / 2; i++) {
			if (check[i] && x - i <= 1000000 && check[x - i]) {
				ans++;
			}
		}

		bw.write(ans + "");

		bw.flush();
	}
}
