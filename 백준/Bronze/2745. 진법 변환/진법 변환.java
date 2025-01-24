import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        int b = Integer.parseInt(st.nextToken());

        int ans = 0, tmp = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9')
                ans += tmp * (c - '0');
            else
                ans += tmp * (c - 'A' + 10);
            tmp *= b;
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}