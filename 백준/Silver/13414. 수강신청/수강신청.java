import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Queue<String> q = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < l; i++) {
            String s = br.readLine();
            q.add(s);
            map.put(s, i);
        }

        int idx = 0;
        while (!q.isEmpty() && k > 0) {
            String s = q.poll();
            if (map.get(s) == idx) {
                bw.write(s + "\n");
                k--;
            }
            idx++;
        }

        bw.flush();
        br.close();
        bw.close();
    }
}