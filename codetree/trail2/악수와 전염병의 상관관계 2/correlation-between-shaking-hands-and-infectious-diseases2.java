import java.util.*;
import java.io.*;

public class Main {
    static class Hand {
        int t, x, y;

        public Hand(int t, int x, int y) {
            this.t = t;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] cnt = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        visited[p] = true;
        List<Hand> hands = new ArrayList<>();
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            hands.add(new Hand(t, x, y));
        }

        Collections.sort(hands, (h1, h2) -> {
            return h1.t - h2.t;
        });

        for (Hand h : hands) {
            boolean xPre = visited[h.x];
            boolean yPre = visited[h.y];
            
            if (visited[h.x] && cnt[h.x] < k) {
                visited[h.y] = true;
            } else if (visited[h.y] && cnt[h.y] < k) {
                visited[h.x] = true;
            }

            if (xPre) cnt[h.x]++;
            if (yPre) cnt[h.y]++;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) bw.write("1");
            else bw.write("0");
        }

        bw.flush();
    }
}