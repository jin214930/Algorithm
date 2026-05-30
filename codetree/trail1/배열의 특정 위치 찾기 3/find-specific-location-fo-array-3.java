import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        while (true) {
            int x = Integer.parseInt(st.nextToken());
            if (x == 0) {
                break;
            }

            if (q.size() == 3) {
                q.poll();
            }
            q.add(x);
        }

        int sum = 0;
        while (!q.isEmpty()) {
            sum += q.poll();
        }

        bw.write(sum + "");

        bw.flush();
    }
}
