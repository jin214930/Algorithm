import java.io.*;
import java.util.*;

public class Main {
    static long a, b, c;

    static long go(long a, long b) {
        if (b == 1)
            return a % c;

        long tmp = go(a, b / 2);
        tmp = tmp * tmp % c;
        if (b % 2 == 0)
            return tmp;
        else
            return tmp * a % c;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());

        bw.write(go(a, b) + "");

        bw.flush();
        bw.close();
        br.close();
    }
}