import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            int n = Integer.parseInt(br.readLine());
            int cnt = 0;
            while (n != 1) {
                if (n % 2 == 0) n /= 2;
                else n = n * 3 + 1;
                cnt++;
            }
            bw.write(cnt + "\n");
        }

        bw.flush();
    }
}