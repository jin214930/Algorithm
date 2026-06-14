import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String p = br.readLine();
        int cnt = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (p.equals(s.substring(i, i + 2))) cnt++;
        }

        bw.write(cnt + "");

        bw.flush();
    }
}
