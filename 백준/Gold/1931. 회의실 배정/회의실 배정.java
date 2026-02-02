import java.io.*;
import java.util.*;

public class Main {
	static class Schedule {
		int s, e;

		public Schedule(int s, int e) {
			this.s = s;
			this.e = e;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		Schedule[] schedules = new Schedule[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			schedules[i] = new Schedule(s, e);
		}

		Arrays.sort(schedules, (s1, s2) -> {
			if (s1.e == s2.e) {
				return s1.s - s2.s;
			}
			return s1.e - s2.e;
		});

		int ans = 0;
		int tmp = 0;
		for (int i = 0; i < n; i++) {
			if (tmp <= schedules[i].s) {
				ans++;
				tmp = schedules[i].e;
			}
		}

		bw.write(ans + "\n");
		bw.flush();
	}
}