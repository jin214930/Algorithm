import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		String[] a = new String[n];
		HashMap<String, Integer> mp = new HashMap<>();
		for (int i = 0; i < n; i++) {
			a[i] = br.readLine();
			if (!mp.containsKey(a[i]))
				mp.put(a[i], i);
		}
		mp.put("", 1000000000);

		int ans = 0;
		String s = "", t = "";
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (a[i].equals(a[j]))
					continue;

				int cnt = 0;
				for (int k = 0; k < Math.min(a[i].length(), a[j].length()); k++) {
					if (a[i].charAt(k) == a[j].charAt(k))
						cnt++;
					else
						break;
				}

				if (cnt > ans) {
					if (mp.get(a[i]) < mp.get(a[j])) {
						s = a[i];
						t = a[j];
					} else {
						s = a[j];
						t = a[i];
					}
					ans = cnt;
				} else if (cnt == ans) {
					if (mp.get(a[i]) < mp.get(a[j])) {
						if (mp.get(a[i]) < mp.get(s)) {
							s = a[i];
							t = a[j];
						} else if (a[i].equals(s) && mp.get(a[j]) < mp.get(t))
							t = a[j];
					} else {
						if (mp.get(a[j]) < mp.get(s)) {
							s = a[j];
							t = a[i];
						} else if (a[j].equals(s) && mp.get(a[i]) < mp.get(t))
							t = a[i];
					}
				}
			}
		}

		// for (int i = 0; i < n - 1; i++) {
		// if (a[i].equals(a[i + 1]))
		// continue;
		// int cnt = 0;
		// for (int j = 0; j < Math.min(a[i].length(), a[i + 1].length()); j++) {
		// if (a[i].charAt(j) == a[i + 1].charAt(j))
		// cnt++;
		// else
		// break;
		// }

		// if (cnt > ans) {
		// if (mp.get(a[i]) < mp.get(a[i + 1])) {
		// s = a[i];
		// t = a[i + 1];
		// } else {
		// s = a[i + 1];
		// t = a[i];
		// }
		// ans = cnt;
		// } else if (cnt == ans) {
		// if (mp.get(a[i]) < mp.get(a[i + 1])) {
		// if (mp.get(a[i]) < mp.get(s)) {
		// s = a[i];
		// t = a[i + 1];
		// } else if (a[i].equals(s) && mp.get(a[i + 1]) < mp.get(t))
		// t = a[i + 1];
		// } else {
		// if (mp.get(a[i + 1]) < mp.get(s)) {
		// s = a[i + 1];
		// t = a[i];
		// } else if (a[i + 1].equals(s) && mp.get(a[i]) < mp.get(t))
		// t = a[i];
		// }
		// }
		// }

		bw.write(s + "\n" + t);
		bw.flush();
		bw.close();
	}
}
