import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int cnt = 0;
		for (int i = 0;i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				if (Integer.parseInt(st.nextToken()) % 5 == 0) {
					cnt++;
				}
			}
		}
		bw.write(String.valueOf(cnt));
		bw.flush();
	}
}
