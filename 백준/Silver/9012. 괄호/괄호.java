import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            String s = br.readLine();
            Deque<Character> stack = new ArrayDeque<>();

            for (char c : s.toCharArray()) {
                if (c == '(') {
                    stack.push(c);
                } else if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }

            bw.write(stack.isEmpty() ? "YES\n" : "NO\n");
        }

        bw.flush();
    }
}
