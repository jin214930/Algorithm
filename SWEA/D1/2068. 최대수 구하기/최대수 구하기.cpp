import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int ans = 0;
            for (int i = 0; i < 10; i++) {
                int x = Integer.parseInt(st.nextToken());
                ans = Math.max(ans, x);
            }

            bw.write("#" + t + " ");
            bw.write(ans + "\n");
        }

        bw.flush();
    }
}
