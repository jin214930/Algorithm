import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n; j++) {
                if (j <= i || j >= 2 * n - 1 - i)
                    bw.write("*");
                else
                    bw.write(" ");
            }
            bw.write("\n");
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < 2 * n; j++) {
                if (j <= i || j >= 2 * n - 1 - i)
                    bw.write("*");
                else
                    bw.write(" ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}