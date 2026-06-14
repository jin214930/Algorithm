import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String s = br.readLine();
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            String tmp = s.substring(i, i + 2);
            if (tmp.equals("ee")) cnt1++;
            else if (tmp.equals("eb")) cnt2++;
        }
        
        bw.write(cnt1 + " " + cnt2);

        bw.flush();
    }
}
