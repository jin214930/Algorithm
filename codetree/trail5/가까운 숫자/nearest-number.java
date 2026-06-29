import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(0);

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = 1000000000;
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (ts.floor(x) != null) {
                d = Math.min(d, Math.abs(x - ts.floor(x)));
            }

            if (ts.ceiling(x) != null) {
                d = Math.min(d, Math.abs(x - ts.ceiling(x)));
            }
            bw.write(d + "\n");
            ts.add(x);
        }

        bw.flush();
    }
}
