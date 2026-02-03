import java.io.*;
import java.util.*;

public class Main {
	static class Line {
		int s, t;

		public Line(int s, int t) {
			this.s = s;
			this.t = t;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		Line[] lines = new Line[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			lines[i] = new Line(s, t);
		}

		Arrays.sort(lines, (c1, c2) -> {
			if (c1.s == c2.s) {
				return c1.t - c2.t;
			}
			return c1.s - c2.s;
		});

		int ans = 0;
		int start = lines[0].s;
		int end = lines[0].t;
		for (int i = 1; i < n; i++) {
			if (lines[i].s > end) {
				ans += end - start;
				start = lines[i].s;
				end = lines[i].t;
			} else {
				end = Math.max(end, lines[i].t);
			}
		}
		ans += end - start;

		bw.write(ans + "\n");
		bw.flush();
	}
}