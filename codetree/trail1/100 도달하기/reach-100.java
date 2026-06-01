import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int a = 1;
        bw.write(a + " " + n + " ");
        while (n < 100) {
            int tmp = n;
            n = a + n;
            a = tmp;
            bw.write(n + " ");
        }

        bw.flush();
    }
}
