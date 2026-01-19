import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] a;
	static StringBuilder sb = new StringBuilder();

	static void go(int idx, List<Integer> list) {
		if (list.size() == 6) {
			for (int i : list)
				sb.append(i).append(" ");
			sb.append("\n");
			return;
		}

		for (int i = idx; i < n; i++) {
			list.add(a[i]);
			go(i + 1, list);
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			if (n == 0)
				break;

			a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = Integer.parseInt(st.nextToken());

			go(0, new ArrayList<>());

			bw.write(sb.toString());
			bw.newLine();
			sb.setLength(0);
		}

		bw.flush();
	}
}