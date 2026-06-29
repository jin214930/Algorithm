import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (map.containsKey(x)) {
                int tmp = map.get(x);
                if (tmp > y) map.put(x, y);
            } else {
                map.put(x, y);
            }
        }

        long ans = 0;
        for (int y : map.values()) ans += y;

        bw.write(ans + "");
        bw.flush();
    }

}
