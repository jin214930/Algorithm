import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Set<Integer> setA = new HashSet<>();
		Set<Integer> setB = new HashSet<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			setA.add(Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			setB.add(Integer.parseInt(st.nextToken()));
		}

		int cnt = 0;
		for (int i : setA) {
			if (setB.contains(i)) {
				cnt++;
			}
		}

		bw.write((setA.size() + setB.size() - 2 * cnt) + "");

		bw.flush();
	}
}
