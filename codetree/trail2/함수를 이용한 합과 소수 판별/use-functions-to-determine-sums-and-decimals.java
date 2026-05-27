import java.io.*;
import java.util.*;

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

    public static boolean check(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n = n / 10;
        }
        
        return sum % 2 == 0;
    }
}
