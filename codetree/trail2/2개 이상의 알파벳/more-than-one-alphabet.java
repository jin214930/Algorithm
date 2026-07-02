import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        if (s.length() == 1) {
            bw.write("No");
            bw.flush();
            return;
        }

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                bw.write("Yes");
                bw.flush();
                return;
            }
        }

        bw.write("No");

        bw.flush();
    }
}