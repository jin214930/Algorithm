import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int ans = 1;
        int cnt = 1;
        int pre = Integer.parseInt(br.readLine());
        for (int i = 1; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x > pre) {
                cnt++;
            } else {
                ans = Math.max(ans, cnt);
                cnt = 1;
            }
            pre = x;
        }

        ans = Math.max(ans, cnt);
        bw.write(ans + "\n");

        bw.flush();
    }
}