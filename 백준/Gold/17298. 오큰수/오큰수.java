import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> stk = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] ans = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            ans[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && a[stk.peek()] < a[i]) {
                ans[stk.peek()] = a[i];
                stk.pop();
            }

            stk.push(i);
        }

        for (int i = 0; i < n; i++)
            bw.write(ans[i] + " ");

        bw.flush();
        bw.close();
        br.close();
    }
}
