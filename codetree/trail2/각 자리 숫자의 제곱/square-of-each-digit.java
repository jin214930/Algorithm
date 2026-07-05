import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int ans = 0;
        for (char c : s.toCharArray()) {
            int tmp = c - '0';
            ans += tmp * tmp;
        }
        bw.write(ans + "");

        bw.flush();
    }
}