import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] a = new String[4];
        for (int i = 0; i < 4; i++) {
            a[i] = br.readLine();
        }

        for (int i = 3; i >= 0; i--) {
            bw.write(a[i] + "\n");
        }

        bw.flush();
    }
}
