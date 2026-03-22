import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		Map<Integer, Integer> map1 = new HashMap<>();
		Map<Integer, Integer> map2 = new HashMap<>();

		List<Integer> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(st.nextToken());
			list.add(x);
			map1.put(x, map1.getOrDefault(x, 0) + 1);
			map2.putIfAbsent(x, i);
		}

		Collections.sort(list, (x1, x2) -> {
			if (map1.get(x1).equals(map1.get(x2))) {
				return map2.get(x1) - map2.get(x2);
			}
			return map1.get(x2) - map1.get(x1);
		});

		for (int x : list) {
			bw.write(x + " ");
		}

		bw.flush();
	}
}
