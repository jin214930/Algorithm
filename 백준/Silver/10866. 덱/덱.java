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

            switch (cmd) {
                case "push_front":
                    dq.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    dq.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    bw.write((dq.isEmpty() ? -1 : dq.pollFirst()) + "\n");
                    break;
                case "pop_back":
                    bw.write((dq.isEmpty() ? -1 : dq.pollLast()) + "\n");
                    break;
                case "size":
                    bw.write(dq.size() + "\n");
                    break;
                case "empty":
                    bw.write((dq.isEmpty() ? 1 : 0) + "\n");
                    break;
                case "front":
                    bw.write((dq.isEmpty() ? -1 : dq.peekFirst()) + "\n");
                    break;
                case "back":
                    bw.write((dq.isEmpty() ? -1 : dq.peekLast()) + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}