import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if (a == 11 && (b < 11 || b == 11 && c < 11)) {
            bw.write("-1");
            bw.flush();
            return;
        }

        int ans = 0;
        if (c < 11) {
            b--;
            c += 60;
        }
        ans += c - 11;
        if (b < 11) {
            a--;
            b += 24;
        }
        ans += (b - 11) * 60;
        ans += (a - 11) * 24 * 60;

        bw.write(ans + "");

        bw.flush();
    }
}