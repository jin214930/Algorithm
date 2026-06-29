import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] cnt = new int[26];

        String s = br.readLine();
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        
        for (char c : s.toCharArray()) {
            if (cnt[c - 'a'] == 1) {
                bw.write(c);
                bw.flush();
                return;
            }
        }

        bw.write("None");

        bw.flush();
    }

}
