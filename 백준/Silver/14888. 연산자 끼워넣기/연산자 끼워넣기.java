import java.io.*;
import java.util.*;

public class Main {
	static int n, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
	static int[] a;
	static int[] opCnt = new int[4];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		a = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			opCnt[i] = Integer.parseInt(st.nextToken());
		}

		go(new ArrayList<>());

		bw.write(max + "\n" + min);

		bw.flush();
	}

	static void go(List<Integer> list) {
		if (list.size() == n - 1) {
			int ret = a[0];
			for (int i = 0; i < n - 1; i++) {
				int op = list.get(i);
				if (op == 0) {
					ret += a[i + 1];
				} else if (op == 1) {
					ret -= a[i + 1];
				} else if (op == 2) {
					ret *= a[i + 1];
				} else {
					ret /= a[i + 1];
				}
			}

			min = Math.min(min, ret);
			max = Math.max(max, ret);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (opCnt[i] == 0)
				continue;
			opCnt[i]--;
			list.add(i);
			go(list);
			opCnt[i]++;
			list.remove(list.size() - 1);
		}
	}
}
