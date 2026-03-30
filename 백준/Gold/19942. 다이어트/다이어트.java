import java.io.*;
import java.util.*;

public class Main {
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] a = new int[4];
		for (int i = 0; i < 4; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		int[][] b = new int[n][5];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				b[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int max = Integer.MAX_VALUE;
		int ans = -1;
		for (int i = 0; i < (1 << n); i++) {
			int[] sum = new int[5];
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) != 0) {
					for (int k = 0; k < 5; k++) {
						sum[k] += b[j][k];
					}
				}
			}
			if (sum[0] >= a[0] && sum[1] >= a[1] && sum[2] >= a[2] && sum[3] >= a[3]) {
				if (max > sum[4]) {
					max = sum[4];
					ans = i;
				} else if (max == sum[4]) {
					if (check(i, ans)) {
						ans = i;
					}

				}
			}
		}

		if (max == Integer.MAX_VALUE) {
			bw.write("-1");
		} else {
			bw.write(max + "\n");
			for (int i = 0; i < n; i++) {
				if ((ans & (1 << i)) != 0) {
					bw.write((i + 1) + " ");
				}
			}
		}

		bw.flush();
	}

	static boolean check(int cur, int best) {
		List<Integer> listCur = new ArrayList<>();
		List<Integer> listBest = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			if ((cur & (1 << i)) != 0)
				listCur.add(i);
			if ((best & (1 << i)) != 0)
				listBest.add(i);
		}

		int minL = Math.min(listCur.size(), listBest.size());
		for (int i = 0; i < minL; i++) {
			if (!listCur.get(i).equals(listBest.get(i))) {
				return listCur.get(i) < listBest.get(i);
			}
		}

		return listCur.size() < listBest.size();
	}
}
