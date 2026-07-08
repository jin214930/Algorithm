import java.util.*;
import java.io.*;

public class Main {
    static int[] dayOfMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());

        int day1 = d1;
        for (int i = 1; i < m1; i++) {
            day1 += dayOfMonth[i];
        }

        int tmp = day1 % 7;
        int day2 = d2;
        for (int i = 1; i < m2; i++) {
            day2 += dayOfMonth[i];
        }

        bw.write(days[(day2 + 7 - tmp) % 7] + "\n");

        bw.flush();
    }
}