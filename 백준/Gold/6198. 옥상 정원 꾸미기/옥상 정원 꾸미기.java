import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n + 1];

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        a[n] = Integer.MAX_VALUE;

        Deque<Integer> stack = new ArrayDeque<>();
        long ans = 0;
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && a[i] >= a[stack.peek()]) {
                int idx = stack.pop();
                ans += i - idx - 1;
            }
            stack.push(i);
        }

        bw.write(ans + "");

        bw.flush();
    }
}
