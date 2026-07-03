import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int tmp = 11 + 2 * i;
            for (int j = 0; j < n; j++) {
                bw.write(tmp + " ");
                tmp += 2;
            }
            bw.newLine();
        }

        bw.flush();
    }
}