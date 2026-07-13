import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        if (n == 2 || n == 3) {
            bw.write("1");
            bw.flush();
            return;
        }
        
        int[] d = new int[n + 1];
        d[2] = 1;
        d[3] = 1;
        for (int i = 4; i <= n; i++) {
            d[i] = (d[i - 2] + d[i - 3]) % 10007;
        }
        bw.write(d[n] + "");

        bw.flush();
    }
}