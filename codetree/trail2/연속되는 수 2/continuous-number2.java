import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        int ans = 0;
        int tmp = -1;
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (tmp == x) {
                cnt++;
            } else {
                ans = Math.max(ans, cnt);
                tmp = x;
                cnt = 1;
            }
        }
        ans = Math.max(ans, cnt);
        bw.write(ans + "\n");
        bw.flush();
    }
}