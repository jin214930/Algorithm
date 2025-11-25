import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            int[] cntA = new int[26];
            int[] cntB = new int[26];

            for (char c : a.toCharArray())
                cntA[c - 'a']++;

            for (char c : b.toCharArray())
                cntB[c - 'a']++;

            boolean flag = true;
            for (int i = 0; i < 26; i++) {
                if (cntA[i] != cntB[i]) {
                    flag = false;
                    break;
                }
            }

            bw.write(flag ? "Possible\n" : "Impossible\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}