import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		if (x > w || y > h) {
			System.out.println(0);
			return;
		}

		int[] ans = { x, y, Math.abs(x - w), Math.abs(y - h) };
		Arrays.sort(ans);
		System.out.println(ans[0]);
	}
}