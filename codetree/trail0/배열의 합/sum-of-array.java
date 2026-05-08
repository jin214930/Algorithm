import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sum = 0;
			for (int j = 0; j < 4;j ++) {
				sum += Integer.parseInt(st.nextToken());
			}
			bw.write(sum + "\n");
		}

		bw.flush();
	}
}
