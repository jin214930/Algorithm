import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int tmp = 2;

        while (n != 1) {
            if (n % tmp == 0) {
                bw.write(tmp + "\n");
                n /= tmp;
            } else
                tmp++;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}