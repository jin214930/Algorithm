import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            if (a[i] % 3 == 0) {
                bw.write(a[i-1] + "");
                bw.flush();
                return;
            }
        }

        bw.flush();
    }
}
