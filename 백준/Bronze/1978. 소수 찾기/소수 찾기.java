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

        int ans = 0;
        for (int x : a) {
            boolean isPrime = true;
            for (int i = 2; i * i <= x; i++) {
                if (x % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            
            if (x != 1 && isPrime) {
                ans++;
            }
        }

        bw.write(ans + "");
        bw.flush();
    }
}