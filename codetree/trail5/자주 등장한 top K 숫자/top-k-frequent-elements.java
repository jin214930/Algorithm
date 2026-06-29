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
        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());

        Collections.sort(list, (x1, x2) -> {
            if (map.get(x1).equals(map.get(x2))) {
                return x2 - x1;
            }
            return map.get(x2) - map.get(x1);
        });

        for (int i = 0; i < k; i++) {
            bw.write(list.get(i) + " ");
        }


        bw.flush();
    }

}
