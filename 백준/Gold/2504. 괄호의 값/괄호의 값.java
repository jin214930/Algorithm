import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        Stack<Character> st = new Stack<>();
        int ans = 0;
        int tmp = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                st.push(c);
                tmp *= 2;
            } else if (c == '[') {
                st.push(c);
                tmp *= 3;
            } else if (c == ')' && !st.isEmpty() && st.peek() == '(') {
                if (s.charAt(i - 1) == '(')
                    ans += tmp;
                st.pop();
                tmp /= 2;
            } else if (c == ']' && !st.isEmpty() && st.peek() == '[') {
                if (s.charAt(i - 1) == '[')
                    ans += tmp;
                st.pop();
                tmp /= 3;
            } else
                st.push(c);
        }

        if (!st.isEmpty())
            ans = 0;

        bw.write(ans + "");

        bw.flush();
        bw.close();
        br.close();
    }
}