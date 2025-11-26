import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> st = new Stack<>();
        long ans = 0;
        while (n-- > 0) {
            int h = Integer.parseInt(br.readLine());

            while (!st.isEmpty() && st.peek() <= h)
                st.pop();
            ans += st.size();
            st.push(h);
        }

        bw.write(ans + "");

        bw.flush();
        bw.close();
        br.close();
    }
}