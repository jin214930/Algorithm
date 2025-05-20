import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Character> st = new ArrayDeque<>();

        String s = br.readLine() + " ";

        boolean flag = false;
        for (char c : s.toCharArray()) {
            if (flag) {
                bw.write(c);
                if (c == '>')
                    flag = false;
            } else {
                if (c == ' ' || c == '<') {
                    while (!st.isEmpty())
                        bw.write(st.pop());
                    bw.write(c);
                    if (c == '<')
                        flag = true;
                } else
                    st.push(c);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
