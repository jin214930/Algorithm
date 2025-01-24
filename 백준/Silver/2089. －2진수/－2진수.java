import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        if (n == 0)
            sb.append(0);

        while (n != 0) {
            int a = n / -2;
            int b = n % -2;
            if (b == -1) {
                a++;
                b = 1;
            }

            n = a;
            sb.append(b);
        }

        bw.write(sb.reverse().toString());
        bw.flush();
        bw.close();
        br.close();
    }
}