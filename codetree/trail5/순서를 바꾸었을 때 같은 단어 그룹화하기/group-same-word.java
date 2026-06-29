import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Integer> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            char[] arr = br.readLine().toCharArray();
            Arrays.sort(arr);
            String s = String.valueOf(arr);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int ans = 0;
        for (int x : map.values()) {
            ans = Math.max(ans, x);
        }

        bw.write(ans + "");
        bw.flush();
    }
}
