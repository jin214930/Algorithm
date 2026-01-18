import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[] a;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	static void go(List<Integer> list) {
		if (list.size() == m) {
			for (int i : list)
				sb.append(i).append(" ");
			sb.append("\n");
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			list.add(a[i]);
			go(list);
			list.remove(list.size() - 1);
			visited[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		a = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(st.nextToken());

		visited = new boolean[n];

		Arrays.sort(a);

		go(new ArrayList<>());

		bw.write(sb.toString());
		bw.flush();
	}
}