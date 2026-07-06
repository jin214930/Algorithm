import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(c);
            else {
                if (stack.isEmpty()) {
                    bw.write("No");
                    bw.flush();
                    return;
                }
                stack.pop();
            }
        }
        
        bw.write(stack.isEmpty() ? "Yes" : "No");

        bw.flush();
    }
}