import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		Cow[] cows = new Cow[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cows[i] = new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(cows, Comparator.comparingInt(c -> c.s));

		int ans = 0;
		for (Cow cow : cows) {
			ans = Math.max(ans, cow.s) + cow.t;
		}

		bw.write(ans + "");

		bw.flush();
	}

	static class Cow {
		int s, t;

		Cow(int s, int t) {
			this.s = s;
			this.t = t;
		}
	}
}
