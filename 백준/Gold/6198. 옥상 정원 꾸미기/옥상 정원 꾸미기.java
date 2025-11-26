import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n + 1];
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(br.readLine());
        a[n] = Integer.MAX_VALUE;

        Stack<Integer> st = new Stack<>();
        long ans = 0;
        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && a[st.peek()] <= a[i])
                ans += i - st.pop() - 1;
            st.push(i);
        }

        bw.write(ans + "");

        bw.flush();
        bw.close();
        br.close();
    }
}