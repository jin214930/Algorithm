import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] cnt = new int[2001];
        int n = Integer.parseInt(br.readLine());
        int k = 1000;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String d = st.nextToken();
            if (d.equals("R")) {
                for (int j = 0; j < x; j++) cnt[k + j]++;
                k += x;
            } else {
                for (int j = 0; j < x; j++) cnt[k - j - 1]++;
                k -= x;
            }
        }

        int ans = 0;
        for (int i = 0; i < 2001; i++) {
            if (cnt[i] >= 2) ans++;
        }
        bw.write(ans + "\n");
        bw.flush();
    }
}