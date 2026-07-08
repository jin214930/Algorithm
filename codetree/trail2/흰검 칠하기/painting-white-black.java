import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] cntB = new int[200001];
        int[] cntW = new int[200001];
        int[] color = new int[200001];

        int now = 100000;
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String d = st.nextToken();
            if (d.equals("R")) {
                for (int i = 0; i < x; i++) {
                    int idx = now + i;
                    if (color[idx] == 3) continue;
                    cntB[idx]++;
                    color[idx] = 2;

                    if (cntB[idx] >= 2 && cntW[idx] >= 2) {
                        color[idx] = 3;
                    }
                }
                now += x - 1;
            } else {
                for (int i = 0; i < x; i++) {
                    int idx = now - i;
                    if (color[idx] == 3) continue;
                    cntW[idx]++;
                    color[idx] = 1;

                    if (cntB[idx] >= 2 && cntW[idx] >= 2) {
                        color[idx] = 3;
                    }
                }
                now = now - x + 1;
            }
        }

        int[] ans = new int[3];
        for (int i = 0; i < 200001; i++) {
            if (color[i] == 1) ans[0]++;
            else if (color[i] == 2) ans[1]++;
            else if (color[i] == 3) ans[2]++;
        }

        bw.write(ans[0] + " " + ans[1] + " " + ans[2]);

        bw.flush();
    }
}