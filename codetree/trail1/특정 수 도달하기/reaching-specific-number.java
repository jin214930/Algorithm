import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a[] = new int[10];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < 10; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            if (a[i] >= 250) {
                break;
            }
            sum += a[i];
            cnt++;
        }

        double avg = (double)sum / cnt;
        bw.write(String.format("%d %.1f", sum, avg));

        bw.flush();
    }
}
