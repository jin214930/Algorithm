import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] cnt = new int[2][7];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            cnt[s][y]++;
        }

        int ans = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j <= 6; j++)
                ans += cnt[i][j] / k + (cnt[i][j] % k > 0 ? 1 : 0);
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}