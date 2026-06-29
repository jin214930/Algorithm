import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }

        long ans = 0;
        for (int j = 0; j < n; j++) {
            map.put(a[j], map.get(a[j]) - 1);

            for (int i = 0; i < j; i++) {
                int target = k - a[j] - a[i];
                ans += map.getOrDefault(target, 0);
            }
        }

        bw.write(ans + "");
        bw.flush();
    }

}
