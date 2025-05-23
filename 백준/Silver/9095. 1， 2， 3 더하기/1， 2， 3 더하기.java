import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] d = new int[11];
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;

        for (int i = 4; i <= 10; i++)
            d[i] = d[i - 1] + d[i - 2] + d[i - 3];

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            bw.write(d[n] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
