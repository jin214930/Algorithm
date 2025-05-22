import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        while (n != 0) {
            int tmp = n % b;
            if (tmp >= 10)
                sb.append((char) ('A' + tmp - 10));
            else
                sb.append(tmp);
            n /= b;
        }

        bw.write(sb.reverse().toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
