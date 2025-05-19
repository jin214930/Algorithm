import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(br.readLine());

        int idx = 0;
        for (int i = 1; i <= n; i++) {
            st.push(i);
            sb.append("+\n");
            while (!st.isEmpty() && st.peek() == a[idx]) {
                st.pop();
                idx++;
                sb.append("-\n");
            }
        }

        if (st.isEmpty())
            bw.write(sb.toString());
        else
            bw.write("NO");

        bw.flush();
        bw.close();
        br.close();
    }
}
