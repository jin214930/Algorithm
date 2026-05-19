import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            if (check(i)) {
                bw.write("0 ");
            } else {
                bw.write(i + " ");
            }
        }

        bw.flush();
    }

    static boolean check(int x) {
        if (x % 3 == 0) {
            return true;
        }

        while (x > 0) {
            int tmp = x % 10;
            if (tmp == 3 || tmp == 6 || tmp == 9) {
                return true;
            }
            x /= 10;
        }
        return false;
    }
}
