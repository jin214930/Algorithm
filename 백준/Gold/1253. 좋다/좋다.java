import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> mp = new HashMap<>();
		HashSet<Integer> ans = new HashSet<>();
		int[] a = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			if (mp.containsKey(a[i]))
				mp.put(a[i], mp.get(a[i]) + 1);
			else
				mp.put(a[i], 1);
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				int tmp = a[i] + a[j];
				if (mp.containsKey(tmp)) {
					if (a[i] == tmp && mp.get(a[i]) == 1)
						continue;
					else if (a[j] == tmp && mp.get(a[j]) == 1)
						continue;
					else if (a[i] == tmp && a[j] == tmp && mp.get(a[i]) <= 2)
						continue;
					ans.add(tmp);
				}
			}
		}

		int cnt = 0;
		for (int i : a) {
			if (ans.contains(i))
				cnt++;
		}

		bw.write(cnt + "");
		bw.flush();
		bw.close();
	}
}