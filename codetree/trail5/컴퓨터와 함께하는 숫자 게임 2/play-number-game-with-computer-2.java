import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long m = Long.parseLong(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        int max = 0, min = Integer.MAX_VALUE;
        for (long i = a; i <= b; i++) {
            long s = 1;
            long e = m;
            int cnt = 1;
            while (s <= e) {
                long mid = (s + e) / 2;
                if (mid == i) {
                    break;
                } else if (mid < i) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
                cnt++;
            }
            max = Math.max(max, cnt);
            min = Math.min(min, cnt);
        }
        
        bw.write(min + " " + max);

        bw.flush();
    }
}
