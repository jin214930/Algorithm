import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Long[] a = new Long[n];
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(br.readLine());
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }

        Arrays.sort(a, (o1, o2) -> {
            if (Objects.equals(map.get(o1), map.get(o2)))
                return o1.compareTo(o2);
            return map.get(o2) - map.get(o1);
        });

        bw.write(a[0] + "");
        bw.flush();
    }
}