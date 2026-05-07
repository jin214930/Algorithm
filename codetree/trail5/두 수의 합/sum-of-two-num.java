import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

       StringTokenizer st = new StringTokenizer(br.readLine());
       int n = Integer.parseInt(st.nextToken());
       int k = Integer.parseInt(st.nextToken());

       Map<Integer, Integer> map = new HashMap<>();
       st = new StringTokenizer(br.readLine());
       for (int i = 0; i < n; i++) {
          int x = Integer.parseInt(st.nextToken());
          map.put(x, map.getOrDefault(x, 0) + 1);
       }

       long ans = 0;
       
       for (int key : map.keySet()) {
          int target = k - key;
          
          if (key < target) {
             if (map.containsKey(target)) {
                ans += (long) map.get(key) * map.get(target);
             }
          } else if (key == target) {
             long count = map.get(key);
             ans += count * (count - 1) / 2;
          }
       }

       bw.write(ans + "");
       bw.flush();
    }
}