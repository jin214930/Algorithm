import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        TreeMap<Integer, Integer> tm = new TreeMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (!tm.containsKey(x)) {
                tm.put(x, i + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : tm.entrySet()) {
            bw.write(entry.getKey() + " " + entry.getValue() + "\n");
        }

        bw.flush();
    }
}
