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

            int[] cnta = new int[26];
            int[] cntb = new int[26];

            for (char c : a.toCharArray())
                cnta[c - 'a']++;
            for (char c : b.toCharArray())
                cntb[c - 'a']++;

            boolean flag = false;
            for (int i = 0; i < 26; i++) {
                if (cnta[i] != cntb[i]) {
                    bw.write("Impossible\n");
                    flag = true;
                    break;
                }
            }

            if (flag)
                continue;

            bw.write("Possible\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}