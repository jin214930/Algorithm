import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                bw.write(String.format("%d * %d = %d", i, j, i * j));
                if (j != n - i + 1) bw.write(" / ");
            }
            bw.newLine();
        }

        bw.flush();
    }
}