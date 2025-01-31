import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] d = new int[1000001];
        d[1] = 0;
        d[2] = 1;
        d[3] = 1;

        for (int i = 4; i <= n; i++) {
            d[i] = d[i - 1] + 1;
            if (i % 3 == 0)
                d[i] = Math.min(d[i], d[i / 3] + 1);
            if (i % 2 == 0)
                d[i] = Math.min(d[i], d[i / 2] + 1);
        }

        bw.write(d[n] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}