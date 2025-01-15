import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();

        String s = br.readLine();
        for (char c : s.toCharArray())
            st1.add(c);

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch (cmd) {
                case "L":
                    if (!st1.empty())
                        st2.add(st1.pop());
                    break;
                case "D":
                    if (!st2.empty())
                        st1.add(st2.pop());
                    break;
                case "B":
                    if (!st1.empty())
                        st1.pop();
                    break;
                default:
                    char c = st.nextToken().charAt(0);
                    st1.add(c);
            }
        }

        while (!st1.empty())
            st2.add(st1.pop());
        while (!st2.empty())
            bw.write(st2.pop());

        bw.flush();
        br.close();
        bw.close();
    }
}
