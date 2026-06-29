import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        TreeSet<Integer> ts = new TreeSet<>();
        for (int i = 1; i <= m; i++) ts.add(i);

        st = new StringTokenizer(br.readLine());
        while (n-- > 0) {
            int x = Integer.parseInt(st.nextToken());
            ts.remove(x);
            bw.write(ts.last() + "\n");
        }

        bw.flush();
    }
}
