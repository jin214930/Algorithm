import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        e--;
        s--;
        m--;

        int ans = 0;

        while (ans % 15 != e || ans % 28 != s || ans % 19 != m) {
            ans++;
        }

        bw.write(ans + 1 + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
