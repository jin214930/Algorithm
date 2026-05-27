import java.io.*;
import java.util.*;

public class Main {
    static int[] days1 = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static int[] days2 = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        if (check(y, m, d)) {
            switch (m) {
                case 3:
                case 4:
                case 5:
                    bw.write("Spring");
                    break;
                case 6:
                case 7:
                case 8:
                    bw.write("Summer");
                    break;
                case 9:
                case 10:
                case 11:
                    bw.write("Fall");
                    break;
                default:
                    bw.write("Winter");
                    break;
            }
        } else {
            bw.write("-1");
        }

        bw.flush();
    }

    public static boolean check(int y, int m, int d) {
        if (check2(y)) {
            return d <= days2[m - 1];
        }
        return d <= days1[m - 1];
    }

    public static boolean check2(int y) {
        return y % 4 == 0 && (y % 400 == 0 || y % 100 != 0);
    }
}
