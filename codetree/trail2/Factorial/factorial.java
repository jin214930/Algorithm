import java.util.*;
import java.io.*;

public class Main {
    static int fac(int x) {
        if (x == 1) return 1;
        return x * fac(x - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        bw.write(fac(n) + "");

        bw.flush();
    }
}