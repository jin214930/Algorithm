import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[] a;
	static Set<List<Integer>> set = new LinkedHashSet<>();

	static void go(List<Integer> list) {
		if (list.size() == m) {
			set.add(new ArrayList<>(list));
			return;
		}

		for (int i = 0; i < n; i++) {
			list.add(a[i]);
			go(list);
			list.remove(list.size() - 1);
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

		Arrays.sort(a);

		go(new ArrayList<>());

		for (List<Integer> list : set) {
			for (int i : list)
				bw.write(i + " ");
			bw.write("\n");
		}

		bw.flush();
	}
}