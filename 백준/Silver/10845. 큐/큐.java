import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        int x = -1;

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "push":
                    x = Integer.parseInt(st.nextToken());
                    q.add(x);
                    break;
                case "pop":
                    bw.write((q.isEmpty() ? -1 : q.poll()) + "\n");
                    break;
                case "size":
                    bw.write(q.size() + "\n");
                    break;
                case "empty":
                    bw.write((q.isEmpty() ? 1 : 0) + "\n");
                    break;
                case "front":
                    bw.write((q.isEmpty() ? -1 : q.peek()) + "\n");
                    break;
                default:
                    bw.write((q.isEmpty() ? -1 : x) + "\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
