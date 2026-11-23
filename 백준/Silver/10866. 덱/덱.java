import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("push_front")) {
                int x = Integer.parseInt(st.nextToken());
                dq.addFirst(x);
            } else if (cmd.equals("push_back")) {
                int x = Integer.parseInt(st.nextToken());
                dq.addLast(x);
            } else if (cmd.equals("pop_front")) {
                if (!dq.isEmpty()) {
                    bw.write(dq.pollFirst() + "\n");
                } else {
                    bw.write("-1\n");
                }
            } else if (cmd.equals("pop_back")) {
                if (!dq.isEmpty()) {
                    bw.write(dq.pollLast() + "\n");
                } else {
                    bw.write("-1\n");
                }
            } else if (cmd.equals("size")) {
                bw.write(dq.size() + "\n");
            } else if (cmd.equals("empty")) {
                bw.write(dq.isEmpty() ? "1\n" : "0\n");
            } else if (cmd.equals("front")) {
                if (!dq.isEmpty()) {
                    bw.write(dq.peekFirst() + "\n");
                } else {
                    bw.write("-1\n");
                }
            } else {
                if (!dq.isEmpty()) {
                    bw.write(dq.peekLast() + "\n");
                } else {
                    bw.write("-1\n");
                }
            }
        }

        bw.flush();
    }
}
