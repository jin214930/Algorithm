import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] a = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int n = Integer.parseInt(br.readLine());
        bw.write(a[n - 1] + "\n");

        bw.flush();
    }
}
