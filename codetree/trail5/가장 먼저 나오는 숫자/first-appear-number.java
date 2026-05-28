import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (map.containsKey(x)) {
                continue;
            }
            map.put(x, i);
        }

        st = new StringTokenizer(br.readLine());
        while (m-- > 0) {
            int x = Integer.parseInt(st.nextToken());
            if (map.containsKey(x)) {
                bw.write(map.get(x) + "\n");
            } else {
                bw.write("-1\n");
            }
        }

        bw.flush();
    }
}
