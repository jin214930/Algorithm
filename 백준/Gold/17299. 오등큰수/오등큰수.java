import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		int[] cnt = new int[1000001];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			cnt[a[i]]++;
		}

		int[] ans = new int[n];
		Arrays.fill(ans, -1);

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && cnt[a[stack.peek()]] < cnt[a[i]]) {
				ans[stack.pop()] = a[i];
			}
			stack.push(i);
		}

		for (int i = 0; i < n; i++) {
			bw.write(ans[i] + " ");
		}

		bw.flush();
	}
}
