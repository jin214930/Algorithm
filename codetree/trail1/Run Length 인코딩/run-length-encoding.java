import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        char tmp = s.charAt(0);
        int cnt = 1;

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            if (tmp != s.charAt(i)) {
                sb.append(tmp).append(cnt);
                tmp = s.charAt(i);
                cnt = 1;
            } else {
                cnt++;
            }
        }

        sb.append(tmp).append(cnt);
        bw.write(sb.length() + "\n" + sb.toString());

        bw.flush();
    }
}
