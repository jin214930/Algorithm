import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int min = 1000, max = -1000;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (true) {
            int x = Integer.parseInt(st.nextToken());
            if (x == 999 || x == -999) break;
            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        bw.write(max + " " + min);

        bw.flush();
    }
}
