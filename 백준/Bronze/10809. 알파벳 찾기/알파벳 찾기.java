import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] a = new int[26];
        Arrays.fill(a, -1);

        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (a[c - 'a'] == -1)
                a[c - 'a'] = i;
        }

        for (int i : a)
            bw.write(i + " ");

        bw.flush();
        bw.close();
        br.close();
    }
}
