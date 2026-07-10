import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            String t = s.substring(0, i);
            if (c == '0') {
                t += "1" + s.substring(i + 1);
            } else {
                t += "0" + s.substring(i + 1);
            }
            ans = Math.max(ans, Integer.parseInt(t, 2));
        }
        
        bw.write(ans + "");


        bw.flush();
    }
}