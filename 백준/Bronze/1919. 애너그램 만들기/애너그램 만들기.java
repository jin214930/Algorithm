import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine();
        String b = br.readLine();

        int[] cntA = new int[26];
        int[] cntB = new int[26];

        for (char c : a.toCharArray())
            cntA[c - 'a']++;

        for (char c : b.toCharArray())
            cntB[c - 'a']++;

        int ans = 0;
        for (int i = 0; i < 26; i++)
            ans += Math.abs(cntA[i] - cntB[i]);

        bw.write(ans + "");

        bw.flush();
        bw.close();
        br.close();
    }
}