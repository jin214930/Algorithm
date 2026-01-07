import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        Integer[] a = new Integer[n];
        st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            map1.put(a[i], map1.getOrDefault(a[i], 0) + 1);
            map2.putIfAbsent(a[i], i);
        }

        Arrays.sort(a, (o1, o2) -> {
            if (Objects.equals(map1.get(o1), map1.get(o2)))
                return map2.get(o1) - map2.get(o2);
            return map1.get(o2) - map1.get(o1);
        });

        for (int i = 0; i < n; i++)
            bw.write(a[i] + " ");

        bw.flush();
    }
}