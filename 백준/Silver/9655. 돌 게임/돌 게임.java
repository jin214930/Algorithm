import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] d = new int[1001];
		d[1] = 1;
		d[3] = 1;
		for (int i = 4; i <= n; i++) {
			if (d[i - 1] == 0 || d[i - 3] == 0)
				d[i] = 1;
		}

		if (d[n] == 0)
			bw.write("CY");
		else
			bw.write("SK");
		bw.flush();
		bw.close();
	}
}
