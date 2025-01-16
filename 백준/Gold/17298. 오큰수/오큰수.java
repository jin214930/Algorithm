import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] ans = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            ans[i] = -1;
        }

        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stk.empty() && a[stk.peek()] < a[i])
                ans[stk.pop()] = a[i];
            stk.add(i);
        }

        for (int i : ans)
            bw.write(i + " ");

        bw.flush();
        br.close();
        bw.close();
    }
}
