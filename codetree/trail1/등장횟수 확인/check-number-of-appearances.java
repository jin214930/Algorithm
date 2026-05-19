import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x % 2 == 0) {
                cnt++;
            }
        }

        bw.write(cnt + "");

        bw.flush();
    }
}
