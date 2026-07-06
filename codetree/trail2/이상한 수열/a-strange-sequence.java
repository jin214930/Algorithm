import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        bw.write(f(n) + "");

        bw.flush();
    }

    static int f(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return f(n - 1) + f(n / 3);
    }
}