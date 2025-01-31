import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(st.nextToken());

        int[] d = new int[n];
        d[0] = a[0];

        int ans = d[0];
        for (int i = 1; i < n; i++) {
            if (d[i - 1] < 0)
                d[i] = a[i];
            else
                d[i] = d[i - 1] + a[i];
            ans = Math.max(d[i], ans);
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}