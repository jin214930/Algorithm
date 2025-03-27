import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= n; i++)
            deque.addLast(i);
        int ans = 0;
        st = new StringTokenizer(br.readLine());
        while (m-- > 0) {
            int cnt = 0;
            int x = Integer.parseInt(st.nextToken());
            while (!deque.isEmpty() && deque.peekFirst() != x) {
                deque.addLast(deque.pollFirst());
                cnt++;
            }
            deque.pollFirst();
            ans += Math.min(cnt, deque.size() - cnt + 1);
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}