import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(st.nextToken());

        int costY = 0, costM = 0;
        for (int i = 0; i < n; i++) {
            costY += (a[i] / 30 + 1) * 10;
            costM += (a[i] / 60 + 1) * 15;
        }

        if (costY < costM)
            bw.write("Y " + costY);
        else if (costY > costM)
            bw.write("M " + costM);
        else
            bw.write("Y M " + costY);

        bw.flush();
        bw.close();
        br.close();
    }
}