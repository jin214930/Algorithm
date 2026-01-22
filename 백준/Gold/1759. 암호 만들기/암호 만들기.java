import java.io.*;
import java.util.*;

public class Main {
	static int l, c;
	static char[] a;
	static StringBuilder sb = new StringBuilder();

	static void go(int idx, List<Character> list) {
		if (list.size() == l) {
			if (check(list)) {
				for (int i = 0; i < l; i++)
					sb.append(list.get(i));
				sb.append('\n');
			}

		}

		for (int i = idx; i < c; i++) {
			list.add(a[i]);
			go(i + 1, list);
			list.remove(list.size() - 1);
		}
	}

	static boolean check(List<Character> list) {
		int cnt = 0;
		for (char c : list) {
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
				cnt++;
		}

		return cnt >= 1 && l - cnt >= 2;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		a = new char[c];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < c; i++)
			a[i] = st.nextToken().charAt(0);

		Arrays.sort(a);

		go(0, new ArrayList<>());

		bw.write(sb.toString());
		bw.flush();
	}
}