import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        if (n % 2 == 0) {
            for (int i = 2; i <= n; i += 2) {
                ans += i;
            }
        } else {
            for (int i = 1; i <= n; i += 2) {
                ans += i;
            }
        }
        bw.write(ans + "");

        bw.flush();
    }
}