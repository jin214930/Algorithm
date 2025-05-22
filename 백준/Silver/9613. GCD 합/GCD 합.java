import java.io.*;
import java.util.*;

public class Main {
    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = Integer.parseInt(st.nextToken());

            long ans = 0;
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++)
                    ans += gcd(a[i], a[j]);
            }

            bw.write(ans + "\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }
}
