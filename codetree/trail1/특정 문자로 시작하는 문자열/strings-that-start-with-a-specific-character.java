import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = br.readLine();
        }

        char c = br.readLine().charAt(0);

        int cnt = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (a[i].charAt(0) == c) {
                cnt++;
                sum += a[i].length();
            }
        }

        bw.write(String.format("%d %.2f", cnt, (double) sum / cnt));

        bw.flush();
    }
}
