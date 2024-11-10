import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		HashMap<String, Integer> mp = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		int idx = 0;
		for (int i = 0; i < n; i++) {
			String s = st.nextToken();
			if (!mp.containsKey(s))
				mp.put(s, idx++);
		}

		int[][] d1 = new int[idx][idx];
		int[][] d2 = new int[idx][idx];
		for (int i = 0; i < idx; i++) {
			Arrays.fill(d1[i], 1000000000);
			Arrays.fill(d2[i], 1000000000);
			d1[i][i] = 0;
			d2[i][i] = 0;
		}

		int m = Integer.parseInt(br.readLine());
		String[] b = new String[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++)
			b[i] = st.nextToken();

		int k = Integer.parseInt(br.readLine());
		while (k-- > 0) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			int x = mp.get(st.nextToken());
			int y = mp.get(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			c *= 2;
			d1[x][y] = Math.min(d1[x][y], c);
			d1[y][x] = Math.min(d1[y][x], c);

			if (s.equals("Mugunghwa") || s.equals("ITX-Saemaeul") || s.equals("ITX-Cheongchun"))
				c = 0;
			else if (s.equals("S-Train") || s.equals("V-Train"))
				c /= 2;
			d2[x][y] = Math.min(d2[x][y], c);
			d2[y][x] = Math.min(d2[y][x], c);
		}

		for (int i = 0; i < idx; i++) {
			for (int j = 0; j < idx; j++) {
				for (int l = 0; l < idx; l++) {
					d1[j][l] = Math.min(d1[j][l], d1[j][i] + d1[i][l]);
					d2[j][l] = Math.min(d2[j][l], d2[j][i] + d2[i][l]);
				}
			}
		}

		int sum1 = 0, sum2 = 2 * r;
		for (int i = 0; i < m - 1; i++) {
			int x = mp.get(b[i]);
			int y = mp.get(b[i + 1]);
			sum1 += d1[x][y];
			sum2 += d2[x][y];
		}

		if (sum1 > sum2)
			bw.write("Yes");
		else
			bw.write("No");
		bw.flush();
		bw.close();
	}
}