import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] cnt = new int[7][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            cnt[y][s]++;
        }

        int ans = 0;
        for (int i = 1; i <= 6; i++) {
            for (int j = 0; j < 2; j++)
                ans += cnt[i][j] / k + (cnt[i][j] % k == 0 ? 0 : 1);
        }

        bw.write(ans + "");
        
        bw.flush();
        bw.close();
        br.close();
    }
}