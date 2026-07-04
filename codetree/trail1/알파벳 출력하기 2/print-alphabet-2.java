import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        char tmp = 'A';
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j < i) bw.write("  ");
                else {
                    bw.write(tmp + " ");
                    tmp = (char) ((tmp - 'A' + 1) % 26 + 'A');
                }
            }
            bw.newLine();
        }

        bw.flush();
    }
}