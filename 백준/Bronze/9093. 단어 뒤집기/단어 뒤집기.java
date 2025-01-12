import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            Stack<Character> st = new Stack<>();
            String s = br.readLine();

            for (char c : s.toCharArray()) {
                if (c == ' ') {
                    while (!st.empty())
                        bw.write(st.pop());
                    bw.write(' ');
                } else
                    st.push(c);
            }

            while (!st.empty())
                bw.write(st.pop());
            bw.write('\n');
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
