import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] cnt = new int[201];
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) + 100;
            int b = Integer.parseInt(st.nextToken()) + 100;
            for (int i = a; i < b; i++) cnt[i]++;
        }

        int ans = 0;
        for (int i = 0; i <= 200; i++) ans = Math.max(ans, cnt[i]);
        bw.write(ans + "");

        bw.flush();
    }
}