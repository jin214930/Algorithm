import java.io.*;
import java.util.*;

public class Main {
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            ans = 0;
            go(n);
            bw.write(ans + "\n");
        }

        bw.flush();
    }

    static void go(int n) {
        if (n < 0) {
            return;
        }

        if (n == 0) {
            ans++;
            return;
        }

        go(n - 1);
        go(n - 2);
        go(n - 3);
    }
}
