import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        Deque<Character> stack = new ArrayDeque<>();

        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(c);
            } else {
                stack.poll();
                if (s.charAt(i - 1) == '(') {
                    ans += stack.size();
                } else {
                    ans++;
                }
            }
        }

        bw.write(ans + "");

        bw.flush();
    }
}
