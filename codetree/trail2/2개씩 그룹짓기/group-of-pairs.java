import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[2 * n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, a[i] + a[2 * n - 1 - i]);
        }

        bw.write(ans + "");

        bw.flush();
    }
}