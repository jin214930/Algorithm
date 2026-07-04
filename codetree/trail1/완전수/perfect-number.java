import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int ans = 0;
        for (int i = a; i <= b; i++) {
            int sum = 0;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) sum += j;
            }
            if (sum == i) ans++;
        }
        bw.write(ans + "");

        bw.flush();
    }
}