import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int x;
            switch (cmd) {
                case "push":
                    x = Integer.parseInt(st.nextToken());
                    pq.add(x);
                    break;
                case "pop":
                    bw.write(pq.poll() + "\n");
                    break;
                case "size":
                    bw.write(pq.size() + "\n");
                    break;
                case "empty":
                    bw.write(pq.isEmpty() ? "1\n" : "0\n");
                    break;
                case "top":
                    bw.write(pq.peek() + "\n");
            }
        }

        bw.flush();
    }
}