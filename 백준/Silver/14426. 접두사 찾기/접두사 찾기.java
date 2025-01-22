import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 1; j <= s.length(); j++)
                set.add(s.substring(0, j));
        }

        int ans = 0;
        while (m-- > 0) {
            String s = br.readLine();
            if (set.contains(s))
                ans++;
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

