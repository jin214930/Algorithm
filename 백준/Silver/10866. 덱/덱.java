import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new LinkedList<>();
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "push_front":
                    dq.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    dq.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    bw.write((dq.isEmpty() ? -1 : dq.poll()) + "\n");
                    break;
                case "pop_back":
                    bw.write((dq.isEmpty() ? -1 : dq.pollLast()) + "\n");
                    break;
                case "size":
                    bw.write(dq.size() + "\n");
                    break;
                case "empty":
                    bw.write(dq.isEmpty() ? "1\n" : "0\n");
                    break;
                case "front":
                    bw.write((dq.isEmpty() ? -1 : dq.peek()) + "\n");
                    break;
                default:
                    bw.write((dq.isEmpty() ? -1 : dq.peekLast()) + "\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
