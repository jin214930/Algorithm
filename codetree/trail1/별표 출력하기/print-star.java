import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < 2 * n - 1; i++) {
            if (i < n) {
                for (int j = 0; j <= i; j++) {
                    bw.write("* ");
                }
            } else {
                for (int j = 0; j < 2 * n - 1 - i; j++) {
                    bw.write("* ");
                }
            }
            bw.newLine();
        }

        bw.flush();
    }
}
