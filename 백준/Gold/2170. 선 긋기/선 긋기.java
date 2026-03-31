import java.io.*;
import java.util.*;

import javax.sound.sampled.Line;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[][] a = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a[i][0] = Integer.parseInt(st.nextToken());
			a[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(a, (o1, o2) -> {
			if (o1[0] == o2[0]) {
				return o1[1] - o2[1];
			}
			return o1[0] - o2[0];
		});

		int ans = 0;
		int s = a[0][0], e = a[0][1];
		for (int i = 0; i < n; i++) {
			if (a[i][0] > e) {
				ans += e - s;
				s = a[i][0];
				e = a[i][1];
			} else {
				e = Math.max(e, a[i][1]);
			}
		}

		ans += e - s;
		bw.write(ans + "\n");

		bw.flush();
	}
}
