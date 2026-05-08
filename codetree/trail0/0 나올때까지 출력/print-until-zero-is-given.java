import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0)
				break;
			bw.write(x + "\n");
		}

		bw.flush();
	}
}
