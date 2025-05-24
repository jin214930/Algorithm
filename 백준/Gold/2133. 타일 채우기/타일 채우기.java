import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        if (n % 2 == 1) {
            bw.write("0");
            bw.flush();
            return;
        }

        int[] d = new int[n + 1];
        d[2] = 3;

        for (int i = 4; i <= n; i += 2) {
            d[i] = d[i - 2] * d[2] + 2;
            for (int j = 4; i - j > 0; j += 2)
                d[i] += 2 * d[i - j];
        }

        bw.write(d[n] + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
