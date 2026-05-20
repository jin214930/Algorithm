import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int sum = 0;
        int cnt = 0;
        for (int i = a; i <= b; i++) {
            if (i % 5 == 0 || i % 7 == 0) {
                sum += i;
                cnt++;
            }
        }

        double avg = (double)sum / cnt;

        bw.write(sum + " " + String.format("%.1f", avg) + "\n");

        bw.flush();
    }
}
