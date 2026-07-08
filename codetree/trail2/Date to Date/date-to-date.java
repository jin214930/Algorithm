import java.util.*;
import java.io.*;

public class Main {
    static int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());

        int ans = 0;
        if (m1 == m2) ans = d2 - d1 + 1;
        else {
            ans = d2 + days[m1] - d1 + 1;
            for (int i = m1 + 1; i < m2; i++)
                ans += days[i];
        }

        bw.write(ans + "");

        bw.flush();
    }
}