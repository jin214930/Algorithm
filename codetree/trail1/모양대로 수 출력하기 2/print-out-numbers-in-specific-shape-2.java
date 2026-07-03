import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(tmp % 8 + 2 + " ");
                tmp += 2;
            }
            bw.newLine();
        }

        bw.flush();
    }
}