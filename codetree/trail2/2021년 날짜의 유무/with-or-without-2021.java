import java.io.*;
import java.util.*;

public class Main {
    static int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        bw.write(check(m, d) ? "Yes" : "No");

        bw.flush();
    }

    public static boolean check(int m, int d) {
        if (m > 12) {
            return false;
        }

        return d <= days[m-1];
    }
}
