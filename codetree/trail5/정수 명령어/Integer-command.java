import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            TreeSet<Integer> ts = new TreeSet<>();
            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int x = Integer.parseInt(st.nextToken());
                if (cmd.equals("I")) {
                    ts.add(x);
                } else if (x == 1) {
                    if (ts.isEmpty()) continue;
                    ts.pollLast();
                } else {
                    if (ts.isEmpty()) continue;
                    ts.pollFirst();
                }
            }

            if (ts.isEmpty()) bw.write("EMPTY\n");
            else bw.write(ts.last() + " " + ts.first() + "\n");
        }

        bw.flush();
    }
}
