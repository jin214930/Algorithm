import java.io.*;
import java.util.*;

public class Main {
    static int go(int n, int r, int c) {
        if (n == 0) return 0;

        int half = 1 << (n - 1);

        if (r < half && c < half)
            return go(n - 1, r, c);
        if (r < half)
            return half * half + go(n - 1, r, c - half);
        if (c < half)
            return half * half * 2 + go(n - 1, r - half, c);

        return half * half * 3 + go(n - 1, r - half, c - half);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());


        bw.write(go(n, r, c) + "");
        bw.flush();
    }
}