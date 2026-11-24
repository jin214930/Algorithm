import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String s = br.readLine();

            if (s.equals(".")) {
                break;
            }

            Deque<Character> stack = new ArrayDeque<>();
            for (char c : s.toCharArray()) {
                if (c == '(' || c == '[') {
                    stack.push(c);
                } else if (c == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.poll();
                    } else {
                        stack.push(c);
                    }
                } else if (c == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.poll();
                    } else {
                        stack.push(c);
                    }
                }
            }

            bw.write(stack.isEmpty() ? "yes\n" : "no\n");

        }

        bw.flush();
    }
}
