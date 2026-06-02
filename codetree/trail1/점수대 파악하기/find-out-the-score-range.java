import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cnt = new int[11];

        while (true) {
            int x = Integer.parseInt(st.nextToken());
            if (x == 0) break;
            cnt[x / 10]++;
        }
        for (int i = 10; i >= 1; i--)
            bw.write(i * 10 + " - " + cnt[i] + "\n");

        bw.flush();
    }
}
