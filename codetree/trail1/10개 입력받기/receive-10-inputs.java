import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = st.countTokens();

        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (x == 0) {
                break;
            }
            sum += x;
            cnt++;
        }

        double avg = (double)sum / cnt;
        bw.write(String.format("%d %.1f", sum, avg));

        bw.flush();
    }
}
