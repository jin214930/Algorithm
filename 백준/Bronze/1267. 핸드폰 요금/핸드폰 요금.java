import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int y = 0, m = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            y += (x / 30 + 1) * 10;
            m += (x / 60 + 1) * 15;
        }

        if (y < m)
            bw.write("Y " + y);
        else if (y > m)
            bw.write("M " + m);
        else
            bw.write("Y M " + y);

        bw.flush();
        bw.close();
        br.close();
    }
}