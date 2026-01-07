import java.io.*;
import java.util.*;

public class Main {
    static int go(int n, int r, int c) {
        if (n == 1) {
            if (r == 0 && c == 0)
                return 0;
            else if (r == 0 && c == 1)
                return 1;
            else if (r == 1 && c == 0)
                return 2;
            else
                return 3;
        }

        int ret = 0;
        int size = (int) Math.pow(2, n);

        if (r < size / 2 && c < size / 2)
            ret = go(n - 1, r, c);
        else if (r < size / 2 && c >= size / 2)
            ret = size * size / 4 + go(n - 1, r, c - size / 2);
        else if (r >= size / 2 && c < size / 2)
            ret = size * size / 2 + go(n - 1, r - size / 2, c);
        else
            ret = size * size / 4 * 3 + go(n - 1, r - size / 2, c - size / 2);

        return ret;
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