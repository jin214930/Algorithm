import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			String[] sBits = br.readLine().split(" ");
			Set<String> set = new HashSet<>();
			while (true) {
				String[] tmp = br.readLine().split(" ");
				if (tmp[tmp.length - 1].equals("say?")) {
					break;
				}

				set.add(tmp[tmp.length - 1]);
			}

			for (String s : sBits) {
				if (!set.contains(s)) {
					bw.write(s + " ");
				}
			}
			bw.write("\n");
		}

		bw.flush();
	}
}
