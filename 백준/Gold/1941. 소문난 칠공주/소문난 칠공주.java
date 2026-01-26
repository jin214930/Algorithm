import java.io.*;
import java.util.*;

public class Main {
	static int ans;
	static char[][] a = new char[5][5];
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};

	static void go(int idx, List<Integer> list, int cnt) {
		if (list.size() == 7) {
			if (check(list))
				ans++;
			return;
		}

		for (int i = idx; i < 25; i++) {
			list.add(i);
			go(i + 1, list, cnt);
			list.remove(list.size() - 1);
		}
	}

	static boolean check(List<Integer> list) {
		boolean[][] tmp = new boolean[5][5];
		boolean[][] visited = new boolean[5][5];
		int cntS = 0;
		for (int i : list) {
			if (a[i / 5][i % 5] == 'S')
				cntS++;
			tmp[i / 5][i % 5] = true;
		}

		if (cntS <= 3)
			return false;

		Queue<Integer> q = new LinkedList<>();
		q.add(list.get(0));
		visited[list.get(0) / 5][list.get(0) % 5] = true;
		int cnt = 1;

		while (!q.isEmpty()) {
			int x = q.poll();

			for (int i = 0; i < 4; i++) {
				int ny = x / 5 + dy[i];
				int nx = x % 5 + dx[i];

				if (ny < 0 || ny >= 5 || nx < 0 || nx >= 5)
					continue;

				if (tmp[ny][nx] && !visited[ny][nx]) {
					visited[ny][nx] = true;
					q.add(ny * 5 + nx);
					cnt++;
				}
			}
		}

		return cnt == 7;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < 5; i++)
			a[i] = br.readLine().toCharArray();

		go(0, new ArrayList<>(), 0);

		bw.write(ans + "");

		bw.flush();
	}
}