import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            dq.offerLast(i);
        }

        st = new StringTokenizer(br.readLine());
        int ans = 0;
        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());

            int cnt = 0;
            while (dq.peekFirst() != x) {
                dq.offerLast(dq.pollFirst());
                cnt++;
            }

            ans += Math.min(cnt, dq.size() - cnt);
            dq.pollFirst();
        }

        bw.write(ans + "");

        bw.flush();
    }
}
