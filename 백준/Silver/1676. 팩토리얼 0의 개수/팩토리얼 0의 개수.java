import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int cnt2 = 0;
        int cnt5 = 0;

        for (int i = 2; i <= n; i *= 2)
            cnt2 += n / i;
        for (int i = 5; i <= n; i *= 5)
            cnt5 += n / i;

        bw.write(Math.min(cnt2, cnt5) + "");


        bw.flush();
        bw.close();
        br.close();
    }
}
