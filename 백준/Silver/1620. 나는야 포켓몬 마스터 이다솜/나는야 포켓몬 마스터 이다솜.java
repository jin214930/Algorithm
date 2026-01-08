import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        String[] a = new String[n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = br.readLine();
            map.put(a[i], i);
        }

        while (m-- > 0) {
            String s = br.readLine();
            if (s.charAt(0) >= '0' && s.charAt(0) <= '9')
                bw.write(a[Integer.parseInt(s)] + "\n");
            else
                bw.write(map.get(s) + "\n");
        }


        bw.flush();
    }
}