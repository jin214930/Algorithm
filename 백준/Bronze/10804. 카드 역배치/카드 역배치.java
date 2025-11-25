import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] a = new int[21];
        for (int i = 1; i <= 20; i++)
            a[i] = i;

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            for (int j = 0; j < (e - s + 1) / 2; j++) {
                int tmp = a[s + j];
                a[s + j] = a[e - j];
                a[e - j] = tmp;
            }
        }

        for (int i = 1; i <= 20; i++)
            bw.write(a[i] + " ");

        bw.flush();
        bw.close();
        br.close();
    }
}