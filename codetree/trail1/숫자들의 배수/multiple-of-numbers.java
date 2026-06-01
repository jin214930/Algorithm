import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 1; ; i++) {
            if (cnt == 2) {
                break;
            }
            int tmp = n * i;
            if (tmp % 5 == 0) {
                cnt++;
            }
            bw.write(tmp + " ");
        }

        bw.flush();
    }
}
