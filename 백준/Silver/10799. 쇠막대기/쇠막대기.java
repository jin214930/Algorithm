import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        Stack<Character> st = new Stack<>();
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                st.pop();
                if (s.charAt(i - 1) == '(')
                    ans += st.size();
                else
                    ans++;
            } else
                st.push(c);
        }

        bw.write(ans + "");
        bw.flush();
        br.close();
        bw.close();
    }
}
