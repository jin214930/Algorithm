import java.io.*;
import java.util.*;

public class Main {
	static int ans, n;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		go(0);

		bw.write(ans + "");

		bw.flush();
	}

	static void go(int idx) {
		if (idx == n) {
			ans++;
			return;
		}

		for (int i = 0; i < n; i++) {
			arr[idx] = i;
			if (check(idx)) {
				go(idx + 1);
			}
		}
	}

	static boolean check(int idx) {
		for (int i = 0; i < idx; i++) {
			if (arr[i] == arr[idx])
				return false;
			if (Math.abs(arr[i] - arr[idx]) == Math.abs(i - idx))
				return false;
		}

		return true;
	}
}
