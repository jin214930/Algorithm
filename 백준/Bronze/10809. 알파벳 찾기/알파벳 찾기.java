import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int[] ans = new int[26];
        Arrays.fill(ans, -1);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (ans[c - 'a'] == -1)
                ans[c - 'a'] = i;
        }

        for (int i : ans)
            bw.write(i + " ");

        bw.flush();
        bw.close();
        br.close();
    }
}

