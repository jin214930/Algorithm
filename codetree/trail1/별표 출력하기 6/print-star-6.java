import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n - 1 - i; j++) {
                if (j < i) bw.write("  ");
                else bw.write("* ");
            }
            bw.newLine();
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n + i + 1; j++) {
                if (j < n - i - 2) bw.write("  ");
                else bw.write("* ");
            }
            bw.newLine();
        }


        bw.flush();
    }
}