import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();

            Stack<Character> st = new Stack<>();
            for (char c : s.toCharArray()) {
                if (!st.isEmpty() && st.peek() == '(' && c == ')')
                    st.pop();
                else
                    st.push(c);
            }

            bw.write(st.isEmpty() ? "YES\n" : "NO\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}