import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
            sum += a[i];
        }

        int avg = sum / n;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] > avg) ans += a[i] - avg;
        }
        
        bw.write(ans + "\n");

        bw.flush();
    }
}