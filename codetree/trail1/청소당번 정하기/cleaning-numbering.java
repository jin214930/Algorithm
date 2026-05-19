import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] cnt = new int[3];
        for (int i = 1; i <= n; i++) {
            if (i % 12 == 0) {
                cnt[0]++;
            } else if (i % 3 == 0) {
                cnt[1]++;
            } else if (i % 2 == 0) {
                cnt[2]++;
            }
        }

        bw.write(cnt[2] + " " + cnt[1] + " " + cnt[0]);

        bw.flush();
    }
}
