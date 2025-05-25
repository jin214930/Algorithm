import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        int tmp = 9;
        while (n > 0) {
            ans += n;
            n -= tmp;
            tmp *= 10;
        }

        bw.write(ans + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
