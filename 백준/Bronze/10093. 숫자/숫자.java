import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		if(a > b) {
			long tmp = a;
			a = b;
			b = tmp;
		}
		bw.write(Math.max(b - a - 1, 0) + "\n");
		for (long i = a + 1; i < b; i++)
			bw.write(i + " ");
		bw.flush();
		bw.close();
	}
}