import java.util.*;
import java.io.*;

public class Main {
    static Map<Long, Long> map = new HashMap<>();
    static long p, q;

    static long go(long n) {
        if (map.containsKey(n))
            return map.get(n);
        long np = go(n / p);
        long nq = go(n / q);
        map.put(n / p, np);
        map.put(n / q, nq);
        return np + nq;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        p = Long.parseLong(st.nextToken());
        q = Long.parseLong(st.nextToken());

        map.put(0L, 1L);

        bw.write(go(n) + "");

        bw.flush();
    }
}