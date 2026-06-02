import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] cnt = new int[7];
        for (int i = 0; i < 10; i++) {
            int x = Integer.parseInt(st.nextToken());
            cnt[x]++;
        }

        for (int i = 1; i < 7; i++) {
            bw.write(i + " - " + cnt[i] + "\n");
        }

        bw.flush();
    }
}
