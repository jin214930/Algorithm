import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] a = {"apple", "banana", "grape", "blueberry", "orange"};
        char c = br.readLine().charAt(0);
        int cnt = 0;
        for (String s : a) {
            if (c == s.charAt(2) || c == s.charAt(3)) {
                bw.write(s + "\n");
                cnt++;
            }
        }

        bw.write(cnt + "");
        bw.flush();
    }
}
