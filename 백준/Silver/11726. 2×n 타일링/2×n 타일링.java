import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] d = new int[1001];
        d[1] = 1;
        d[2] = 2;

        for (int i = 3; i <= n; i++)
            d[i] = (d[i - 1] + d[i - 2]) % 10007;

        bw.write(d[n] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}