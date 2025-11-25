import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String n = br.readLine();

        int[] cnt = new int[9];
        for (char c : n.toCharArray()) {
            if (c == '9')
                cnt[6]++;
            else
                cnt[c - '0']++;
        }

        cnt[6] = cnt[6] / 2 + (cnt[6] % 2 == 1 ? 1 : 0);

        int ans = 0;
        for (int i : cnt)
            ans = Math.max(ans, i);

        bw.write(ans + "");

        bw.flush();
        bw.close();
        br.close();
    }
}