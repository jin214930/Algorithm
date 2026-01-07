import java.io.*;
import java.util.*;

public class Main {
    static class Score {
        String name;
        int k, e, m;

        public Score(String name, int k, int e, int m) {
            this.name = name;
            this.k = k;
            this.e = e;
            this.m = m;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Score[] scores = new Score[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int k = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            scores[i] = new Score(name, k, e, m);
        }

        Arrays.sort(scores, (a, b) -> {
            if (a.k != b.k)
                return b.k - a.k;
            if (a.e != b.e)
                return a.e - b.e;
            if (a.m != b.m)
                return b.m - a.m;
            return a.name.compareTo(b.name);
        });

        for (Score score : scores) {
            bw.write(score.name + "\n");
        }

        bw.flush();
    }
}