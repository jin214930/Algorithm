import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n + 1];
        a[n] = 1000000000;
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(br.readLine());

        long ans = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && a[i] >= a[st.peek()]) {
                ans += i - st.peek() - 1;
                st.pop();
            }

            st.push(i);
        }

        bw.write(ans + "");
        bw.flush();
    }
}