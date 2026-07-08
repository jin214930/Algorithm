import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] color = new int[200001];

        int now = 100000;
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String d = st.nextToken();
            if (d.equals("R")) {
                for (int i = 0; i < x; i++) {
                    int idx = now + i;
                    color[idx] = 2;
                }
                now += x - 1;
            } else {
                for (int i = 0; i < x; i++) {
                    int idx = now - i;
                    color[idx] = 1;
                }
                now = now - x + 1;
            }
        }

        int[] ans = new int[2];
        for (int i = 0; i < 200001; i++) {
            if (color[i] == 1) ans[0]++;
            else if (color[i] == 2) ans[1]++;
        }

        bw.write(ans[0] + " " + ans[1]);

        bw.flush();
    }
}