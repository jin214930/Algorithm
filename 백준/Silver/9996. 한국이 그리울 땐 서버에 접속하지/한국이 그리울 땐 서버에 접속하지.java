import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String p = br.readLine();
        String pre = p.substring(0, p.indexOf('*'));
        String suf = p.substring(p.indexOf('*') + 1);

        while (n-- > 0) {
            String s = br.readLine();

            if (pre.length() + suf.length() > s.length()) {
                bw.write("NE\n");
                continue;
            }

            if (s.startsWith(pre) && s.endsWith(suf))
                bw.write("DA\n");
            else
                bw.write("NE\n");
        }

        bw.flush();
    }
}
