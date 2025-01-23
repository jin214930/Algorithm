import java.io.*;
import java.util.*;

public class Main {
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int ans = 0;

        st = new StringTokenizer(br.readLine());
        while (n-- > 0) {
            int a = Integer.parseInt(st.nextToken());
            if (ans == 0)
                ans = Math.abs(s - a);
            else
                ans = gcd(ans, Math.abs(s - a));
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}