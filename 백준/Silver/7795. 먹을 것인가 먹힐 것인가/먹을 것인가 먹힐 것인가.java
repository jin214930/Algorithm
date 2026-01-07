import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] b = new int[m];
            for (int i = 0; i < m; i++)
                b[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(a);
            Arrays.sort(b);

            int idx = 0;
            int ans = 0;
            for (int i = 0; i < n; i++) {
                while (idx < m && b[idx] < a[i])
                    idx++;
                ans += idx;
            }
            bw.write(ans + "\n");
        }


        bw.flush();
    }
}