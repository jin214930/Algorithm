import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int sum = 0, cnt = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            sum += s.length();
            if (s.charAt(0) == 'a') cnt++;
        }
        bw.write(sum + " " + cnt);

        bw.flush();
    }
}
