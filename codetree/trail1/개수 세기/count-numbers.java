import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            if (a[i] == m) {
                cnt++;
            }
        }

        bw.write(cnt + "");
        bw.flush();
    }
}
