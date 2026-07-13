import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] d = new int[n + 1];
        d[0] = 1;
        d[1] = 1;

        for (int i = 2; i <= n; i++)
            d[i] = (d[i - 1] + d[i - 2] * 2) % 10007;

        bw.write(d[n] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}