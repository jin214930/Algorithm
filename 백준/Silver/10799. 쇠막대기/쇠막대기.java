import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int ans = 0;
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(')
                st.push(c);
            else {
                if (s.charAt(i - 1) == '(') {
                    st.pop();
                    ans += st.size();
                } else {
                    st.pop();
                    ans++;
                }
            }
        }

        bw.write(ans + "");

        bw.flush();
        bw.close();
        br.close();
    }
}