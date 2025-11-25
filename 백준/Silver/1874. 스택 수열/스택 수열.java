import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(br.readLine());

        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            st.push(i);
            sb.append("+\n");
            while (!st.isEmpty() && st.peek() == a[idx]) {
                sb.append("-\n");
                st.pop();
                idx++;
            }
        }

        if (!st.isEmpty())
            bw.write("NO");
        else
            bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}