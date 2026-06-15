import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 1;
        int min = 1000;
        for (int i = 0; i < 10; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (x < 500) max = Math.max(max, x);
            else if (x > 500) min = Math.min(min, x);
        }

        bw.write(max + " " + min);

        bw.flush();
    }
}
