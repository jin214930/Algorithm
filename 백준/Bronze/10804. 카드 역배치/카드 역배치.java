import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a[] = new int[21];

        for (int i = 1; i <= 20; i++)
            a[i] = i;

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            while (y > x) {
                int temp = a[x];
                a[x] = a[y];
                a[y] = temp;
                x++;
                y--;
            }
        }

        for (int i = 1; i <= 20; i++)
            bw.write(a[i] + " ");

        bw.flush();
        bw.close();
        br.close();
    }
}