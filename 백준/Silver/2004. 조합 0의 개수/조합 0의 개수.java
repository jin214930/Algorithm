import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long cnt5 = 0, cnt2 = 0;

        for (long i = 2; i <= n; i *= 2)
            cnt2 += n / i;
        for (long i = 5; i <= n; i *= 5)
            cnt5 += n / i;
        for (long i = 2; i <= m; i *= 2)
            cnt2 -= m / i;
        for (long i = 5; i <= m; i *= 5)
            cnt5 -= m / i;
        for (long i = 2; i <= n - m; i *= 2)
            cnt2 -= (n - m) / i;
        for (long i = 5; i <= n - m; i *= 5)
            cnt5 -= (n - m) / i;

        bw.write(Math.min(cnt2, cnt5) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

