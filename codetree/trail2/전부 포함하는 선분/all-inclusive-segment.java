import java.util.*;
import java.io.*;

public class Main {
    static class Line {
        int s, e;

        public Line(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Line[] lines = new Line[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lines[i] = new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int ans = 100;
        for (int i = 0; i < n; i++) {
            int s = 100;
            int e = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                s = Math.min(s, lines[j].s);
                e = Math.max(e, lines[j].e);
            }
            ans = Math.min(ans, e - s);
        }
        bw.write(ans + "");

        bw.flush();
    }
}