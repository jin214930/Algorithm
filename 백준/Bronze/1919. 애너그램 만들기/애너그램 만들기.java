import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String a = br.readLine();
        String b = br.readLine();

        int[] cnta = new int[26];
        int[] cntb = new int[26];

        for (char c : a.toCharArray())
            cnta[c - 'a']++;
        for (char c : b.toCharArray())
            cntb[c - 'a']++;

        int ans = 0;
        for (int i = 0; i < 26; i++)
            ans += Math.abs(cnta[i] - cntb[i]);

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}