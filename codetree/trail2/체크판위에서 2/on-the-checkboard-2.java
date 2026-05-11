import java.util.*;
import java.io.*;

public class Main {
    static int r, c, ans;
    static String[][] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        a = new String[r][c];
        for (int i = 0; i < r; i++) {
            a[i] = br.readLine().split(" ");
        }

        go(0, 0, 0);

        bw.write(ans + "");
        bw.flush();
    }

    static void go(int y, int x, int cnt) {
        if (cnt > 3) {
            return;
        }
        if (y == r - 1 && x == c - 1 && cnt == 3) {
            ans++;
        }

        for (int i = y + 1; i < r; i++) {
            for (int j = x + 1; j < c; j++) {
                if (!a[y][x].equals(a[i][j])) {
                    go(i, j, cnt + 1);
                }
            }
        }
    }
}
