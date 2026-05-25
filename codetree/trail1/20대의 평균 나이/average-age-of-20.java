import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum = 0;
        int cnt = 0;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n / 10 != 2) {
                break;
            }
            sum += n;
            cnt++;
        }

        double avg = (double)sum / cnt;
        bw.write(String.format("%.2f", avg));

        bw.flush();
    }
}
