import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Character> st = new ArrayDeque<>();

        String s = br.readLine();

        for (char c : s.toCharArray()) {
            if (c >= 'A' && c <= 'Z')
                bw.write(c);
            else {
                if (c == '+' || c == '-') {
                    while (!st.isEmpty() && st.peek() != '(')
                        bw.write(st.pop());
                    st.push(c);
                } else if (c == '*' || c == '/') {
                    while (!st.isEmpty() && (st.peek() != '+' && st.peek() != '-' && st.peek() != '('))
                        bw.write(st.pop());
                    st.push(c);
                } else if (c == '(')
                    st.push(c);
                else {
                    while (!st.isEmpty() && st.peek() != '(')
                        bw.write(st.pop());
                    st.pop();
                }
            }
        }

        while (!st.isEmpty())
            bw.write(st.pop());

        bw.flush();
        bw.close();
        br.close();
    }
}
