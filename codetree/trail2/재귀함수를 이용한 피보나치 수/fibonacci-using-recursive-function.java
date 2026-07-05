import java.util.*;
import java.io.*;

public class Main {
    static int fibo(int x) {
        if (x == 1 || x == 2) return 1;
        return fibo(x - 1) + fibo(x - 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        bw.write(fibo(n) + "");

        bw.flush();
    }
}