import java.io.*;
import java.util.*;

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

        int tmp = n;
        int idx = -1;
        while (tmp > 0) {
            int max = 0;
            for (int i = 0; i < tmp; i++) {
                if (max < a[i]) {
                    max = a[i];
                    idx = i;
                }
            }

            bw.write(idx + 1 + " ");
            tmp = idx;
        }

        bw.flush();
    }
}
