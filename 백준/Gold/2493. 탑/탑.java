import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(st.nextToken());

        Stack<Integer> stk = new Stack<>();
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && a[stk.peek()] < a[i])
                ans[stk.pop()] = i + 1;
            stk.push(i);
        }

        for (int i : ans)
            bw.write(i + " ");

        bw.flush();
        bw.close();
        br.close();
    }
}