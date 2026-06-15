import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 100;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                ans = Math.min(ans, Math.abs(a[i] - a[j]));
            }
        }

        bw.write(ans + "");

        bw.flush();
    }
}
