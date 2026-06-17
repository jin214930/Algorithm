import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Character> dq = new ArrayDeque<>();
        String s = br.readLine();
        for (char c : s.toCharArray()) {
            dq.addLast(c);
        }

        String cmd = br.readLine();
        for (char c : cmd.toCharArray()) {
            if (c == 'L') {
                dq.addLast(dq.pollFirst());
            } else {
                dq.addFirst(dq.pollLast());
            }
        }

        while (!dq.isEmpty()) {
            bw.write(dq.pollFirst());
        }

        bw.flush();
    }
}
