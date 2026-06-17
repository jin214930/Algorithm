import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Integer.parseInt(br.readLine());
        }

        Deque<Integer> dq = new ArrayDeque<>();
        while (sum != 0) {
            dq.addFirst(sum % 10);
            sum = sum / 10;
        }

        dq.addLast(dq.pollFirst());

        while (!dq.isEmpty()) {
            bw.write(dq.pollFirst() + "");
        }

        bw.flush();
    }
}
