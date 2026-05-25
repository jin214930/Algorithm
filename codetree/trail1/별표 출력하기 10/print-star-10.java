import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < 2 * n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < i / 2 + 1; j++) {
                    bw.write("* ");
                }
            } else {
                for (int j = 0; j < n - (i - 1) / 2; j++) {
                    bw.write("* ");
                }
            }
            bw.newLine();
        }

        bw.flush();
    }
}
