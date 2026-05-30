import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum1 = 0, sum2 = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 10; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (i % 2 == 0) {
                sum1 += x;
            }
            if (i % 3 == 0) {
                sum2 += x;
            }
        }

        double avg = sum2 / 3.0;
        bw.write(String.format("%d %.1f", sum1, avg));

        bw.flush();
    }
}
