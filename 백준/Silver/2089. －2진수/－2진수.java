import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        if (n == 0)
            bw.write("0");
        else {
            StringBuilder sb = new StringBuilder();

            while (n != 1) {
                if (n > 0) {
                    sb.insert(0, n % -2);
                    n /= -2;
                } else {
                    sb.insert(0, Math.abs(n % -2));
                    n = n / -2 + Math.abs(n % -2);
                }
            }

            sb.insert(0, 1);
            bw.write(sb.toString());
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
