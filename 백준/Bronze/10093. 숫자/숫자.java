import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] a = new long[2];
        for (int i = 0; i < 2; i++)
            a[i] = Long.parseLong(st.nextToken());

        Arrays.sort(a);

        if (a[1] - a[0] <= 1)
            bw.write("0");
        else {
            bw.write((a[1] - a[0] - 1) + "\n");
            for (long i = a[0] + 1; i < a[1]; i++)
                bw.write(i + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}