import java.util.*;
import java.io.*;

public class Main {
    static class Person {
        String name;
        int score;

        Person(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Person ans = null;
        int tmp = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            if (score < tmp) {
                tmp = score;
                ans = new Person(name, score);
            }
        }
        
        bw.write(ans.name + " " + ans.score);

        bw.flush();
    }
}