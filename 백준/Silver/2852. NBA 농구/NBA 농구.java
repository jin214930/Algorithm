import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int score1 = 0, score2 = 0;
		int ans1 = 0, ans2 = 0;

		int prev = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int team = Integer.parseInt(st.nextToken());
			int time = stoi(st.nextToken());

			if (score1 > score2) {
				ans1 += time - prev;
			} else if (score1 < score2) {
				ans2 += time - prev;
			}

			if (team == 1) {
				score1++;
			} else {
				score2++;
			}
			prev = time;
		}

		if (score1 > score2) {
			ans1 += stoi("48:00") - prev;
		} else if(score1 < score2) {
			ans2 += stoi("48:00") - prev;
		}

		bw.write(itos(ans1) + "\n" + itos(ans2));

		bw.flush();
	}

	static int stoi(String time) {
		int m = Integer.parseInt(time.substring(0, 2));
		int s = Integer.parseInt(time.substring(3));

		return m * 60 + s;
	}

	static String itos(int i) {
		return String.format("%02d:%02d", i / 60, i % 60);
	}
}
