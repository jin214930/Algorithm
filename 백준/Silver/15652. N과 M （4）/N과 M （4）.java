import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static StringBuilder sb = new StringBuilder();

	static void go(int idx, List<Integer> list) {
		if (list.size() == m) {
			for (int i : list)
				sb.append(i).append(" ");
			sb.append("\n");
			return;
		}

		for (int i = idx; i <= n; i++) {
			list.add(i);
			go(i, list);
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		go(1, new ArrayList<>());

		bw.write(sb.toString());
		bw.flush();
	}
}