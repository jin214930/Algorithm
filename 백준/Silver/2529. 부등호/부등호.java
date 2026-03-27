import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static String[] a;
	static boolean[] visited = new boolean[10];
	static List<String> ans = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		a = new String[n];

		a = br.readLine().split(" ");

		go("");

		Collections.sort(ans);

		bw.write(ans.get(ans.size() - 1) + "\n" + ans.get(0));

		bw.flush();
	}

	static void go(String s) {
		if (s.length() == n + 1) {
			if (check(s)) {
				ans.add(s);
			}
			return;
		}

		for (int i = 0; i < 10; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			go(s + i);
			visited[i] = false;
		}
	}

	static boolean check(String s) {
		boolean flag = true;
		for (int i = 0; i < n; i++) {
			if (a[i].equals("<")) {
				if (s.charAt(i) > s.charAt(i + 1)) {
					flag = false;
					break;
				}
			} else {
				if (s.charAt(i) < s.charAt(i + 1)) {
					flag = false;
					break;
				}
			}
		}
		return flag;
	}
}
