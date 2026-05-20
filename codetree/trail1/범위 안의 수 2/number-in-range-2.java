import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < 10; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x >= 0 && x <= 200) {
                sum += x;
                cnt++;
            }
        }

        double avg = (double)sum / cnt;

        bw.write(sum + " " + String.format("%.1f", avg) + "\n");

        bw.flush();
    }
}
