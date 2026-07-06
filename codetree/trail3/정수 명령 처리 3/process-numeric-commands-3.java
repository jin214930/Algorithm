import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int x;
            switch (cmd) {
                case "push_front":
                    x = Integer.parseInt(st.nextToken());
                    dq.addFirst(x);
                    break;
                case "push_back":
                    x = Integer.parseInt(st.nextToken());
                    dq.addLast(x);
                    break;
                case "pop_front":
                    bw.write(dq.pollFirst() + "\n");
                    break;
                case "pop_back":
                    bw.write(dq.pollLast() + "\n");
                    break;
                case "size":
                    bw.write(dq.size() + "\n");
                    break;
                case "empty":
                    bw.write((dq.isEmpty() ? 1 : 0) + "\n");
                    break;
                case "front":
                    bw.write(dq.peekFirst() + "\n");
                    break;
                case "back":
                    bw.write(dq.peekLast() + "\n");
            }
        }

        bw.flush();
    }
}