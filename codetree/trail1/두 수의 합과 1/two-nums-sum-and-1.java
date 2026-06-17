import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        a += b;
        int cnt = 0;
        while (a > 0) {
            if (a % 10 == 1) cnt++;
            a /= 10;
        }

        bw.write(cnt + "");

        bw.flush();
    }
}
