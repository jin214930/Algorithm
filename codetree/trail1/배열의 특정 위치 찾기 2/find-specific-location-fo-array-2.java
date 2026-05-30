import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum1 = 0, sum2 = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                sum1 += Integer.parseInt(st.nextToken());
            } else {
                sum2 += Integer.parseInt(st.nextToken());
            }
        }

        bw.write(Math.abs(sum1 - sum2) + "");

        bw.flush();
    }
}
