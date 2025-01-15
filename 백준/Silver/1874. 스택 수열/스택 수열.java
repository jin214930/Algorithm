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

        int idx = 0;
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            st.add(i);
            sb.append("+\n");

            while (!st.empty() && st.peek() == a[idx]) {
                st.pop();
                sb.append("-\n");
                idx++;
            }
        }

        if (st.empty()) {
            bw.write(sb.toString());
        } else {
            bw.write("NO");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
