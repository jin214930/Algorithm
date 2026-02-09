import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] a = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(st.nextToken());

		Set<Integer> set = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int x = Integer.parseInt(st.nextToken());
			set.add(x);
		}

		List<Integer> list = new ArrayList<>();
		for (int x : a)
			if (!set.contains(x))
				list.add(x);

		Collections.sort(list);
		bw.write(list.size() + "\n");
		for (int x : list)
			bw.write(x + " ");

		bw.flush();
	}
}