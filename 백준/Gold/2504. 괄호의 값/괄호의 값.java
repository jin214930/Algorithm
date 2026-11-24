import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int ans = 0;
        int tmp = 1;
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(c);
                tmp *= 2;
            } else if (c == '[') {
                stack.push(c);
                tmp *= 3;
            } else if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    if (i - 1 >= 0 && s.charAt(i - 1) == '(') {
                        ans += tmp;
                    }
                    tmp /= 2;
                    stack.poll();
                } else {
                    stack.push(c);
                }
            } else {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    if (i - 1 >= 0 && s.charAt(i - 1) == '[') {
                        ans += tmp;
                    }
                    tmp /= 3;
                    stack.poll();
                } else {
                    stack.push(c);
                }
            }
        }

        bw.write((stack.isEmpty() ? ans : 0) + "");

        bw.flush();
    }
}
