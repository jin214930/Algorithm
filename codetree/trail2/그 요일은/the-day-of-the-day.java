import java.util.*;
import java.io.*;

public class Main {
    static int[] mon = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());
        String a = br.readLine();
        int tmp = -1;
        for (int i = 0; i < days.length; i++) {
            if (days[i].equals(a)) {
                tmp = i;
            }
        }

        int day1 = d1;
        for (int i = 1; i < m1; i++) {
            day1 += mon[i];
        }

        int day2 = d2;
        for (int i = 1; i < m2; i++) {
            day2 += mon[i];
        }

        int ans = (day2 - day1) / 7 + ((day2 - day1) % 7 >= tmp ? 1 : 0);
        bw.write(ans + "");


        bw.flush();
    }
}