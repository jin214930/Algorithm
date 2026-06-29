import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        TreeMap<String, Integer> tm = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            tm.put(s, tm.getOrDefault(s, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : tm.entrySet()) {
            bw.write(entry.getKey() + " " + entry.getValue() + "\n");
        }

        bw.flush();
    }
}
