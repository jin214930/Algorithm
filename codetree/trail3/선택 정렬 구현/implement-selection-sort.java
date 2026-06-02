import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n - 1; i++) {
            int idx = i;
            for (int j = i + 1; j < n; j++) {
                if (a[idx] > a[j]) {
                    idx = j;
                }
            }
            int tmp = a[i];
            a[i] = a[idx];
            a[idx] = tmp;
        }

        for (int j = 0; j < n; j++) {
            bw.write(a[j] + " ");
        }

        bw.flush();
    }
}
