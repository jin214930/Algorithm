import java.io.*;
import java.util.*;

public class Main {
	static int[] a = new int[9];
	static List<Integer> ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < 9; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(a);

		go(0, new ArrayList<>());

		for (int i : ans) {
			bw.write(i + "\n");
		}
		bw.flush();
	}

	static void go(int idx, List<Integer> list) {
		if (list.size() == 7) {
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += list.get(i);
			}

			if (sum == 100) {
				ans = List.copyOf(list);
			}
			return;
		}

		for (int i = idx; i < 9; i++) {
			list.add(a[i]);
			go(i + 1, list);
			list.remove(list.size() - 1);
		}
	}
}
