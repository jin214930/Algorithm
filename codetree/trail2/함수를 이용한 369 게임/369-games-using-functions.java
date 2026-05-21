import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int cnt = 0;
        for (int i = a; i <= b; i++) {
            if (check(i)) {
                cnt++;
            }
        }

        bw.write(cnt + "");
        bw.flush();
    }

    static boolean check(int x) {
        if (x % 3 == 0) {
            return true;
        }

        while (x != 0) {
            int tmp = x % 10;
            if (tmp == 3 || tmp == 6 || tmp == 9) {
                return true;
            }
            x /= 10;
        }

        return false;
    }
}
