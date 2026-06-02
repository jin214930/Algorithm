import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] cnt = new int[10];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        while (a > 1) {
            cnt[a % b]++;
            a /= b;
        }

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += cnt[i] * cnt[i];
        }
        bw.write(sum + "");

        bw.flush();
    }
}
