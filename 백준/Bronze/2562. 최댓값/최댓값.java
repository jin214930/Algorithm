import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int mx = 0, idx = -1;
        for (int i = 0; i < 9; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if (mx < tmp) {
                mx = tmp;
                idx = i + 1;
            }
        }

        bw.write(mx + "\n");
        bw.write(idx + "");

        bw.flush();
        bw.close();
        br.close();
    }
}