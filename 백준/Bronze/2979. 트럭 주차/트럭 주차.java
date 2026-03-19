import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] fee = new int[3];
		for (int i = 0; i < 3; i++)
			fee[i] = Integer.parseInt(st.nextToken());

		int cnt[] = new int[101];
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			for (int j = s; j < e; j++)
				cnt[j]++;
		}

		int ans = 0;
		for (int i = 0; i <= 100; i++) {
			if (cnt[i] == 0)
				continue;
			ans += cnt[i] * fee[cnt[i] - 1];
		}

		bw.write(ans + "");

		bw.flush();
	}
}
