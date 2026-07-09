import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] cnt = new int[n + 1];
        while (m-- > 0) {
            int x = Integer.parseInt(br.readLine());
            cnt[x]++;
            if (cnt[x] >= k) {
                bw.write(x + "");
                bw.flush();
                return;
            }
        }

        bw.write("-1");
        bw.flush();
    }
}