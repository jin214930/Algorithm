import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        int x = 0;

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("push")) {
                x = Integer.parseInt(st.nextToken());
                q.offer(x);
            } else if (cmd.equals("pop")) {
                if (!q.isEmpty()) {
                    bw.write(q.poll() + "\n");
                } else {
                    bw.write("-1\n");
                }
            } else if (cmd.equals("size")) {
                bw.write(q.size() + "\n");
            } else if (cmd.equals("empty")) {
                bw.write(q.isEmpty() ? "1\n" : "0\n");
            } else if (cmd.equals("front")) {
                if (!q.isEmpty()) {
                    bw.write(q.peek() + "\n");
                } else {
                    bw.write("-1\n");
                }
            } else {
                if (!q.isEmpty()) {
                    bw.write(x + "\n");
                } else {
                    bw.write("-1\n");
                }
            }
        }

        bw.flush();
    }
}
