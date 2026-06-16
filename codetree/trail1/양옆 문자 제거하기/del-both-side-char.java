import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            if (i == 1 || i == s.length() - 2) continue;
            bw.write(s.charAt(i));
        }

        bw.flush();
    }
}
