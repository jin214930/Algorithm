import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 4 == 0 && !(i % 100 == 0 && i % 400 != 0)) {
                cnt++;
            }
        }

        bw.write(cnt + "");

        bw.flush();
    }
}
