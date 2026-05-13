import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        if (n % 2 == 0) {
            n /= 2;
            if (n % 2 == 1) {
                n = (n + 1) / 2;
            }
        } else {
            n = (n + 1) / 2;
        }

        bw.write(String.valueOf(n));

        bw.flush();
    }
}
