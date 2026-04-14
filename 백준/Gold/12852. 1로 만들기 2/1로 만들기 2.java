import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] d = new int[n + 1];
		int[] pre = new int[n + 1];

		d[1] = 0;
		for (int i = 2; i <= n; i++) {
			d[i] = d[i - 1] + 1;
			pre[i] = i - 1;
			if (i % 2 == 0 && d[i] > d[i / 2] + 1) {
				d[i] = d[i / 2] + 1;
				pre[i] = i / 2;
			}
			if (i % 3 == 0 && d[i] > d[i / 3] + 1) {
				d[i] = d[i / 3] + 1;
				pre[i] = i / 3;
			}
		}

		bw.write(d[n] + "\n");
		for (int i = n; i != 0; i = pre[i]) {
			bw.write(i + " ");
		}
		bw.flush();
	}
}
