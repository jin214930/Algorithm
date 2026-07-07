import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            list.add(x);
            if (i % 2 == 0) {
                Collections.sort(list);
                bw.write(list.get(i / 2) + " ");
            }
        }

        bw.flush();
    }
}