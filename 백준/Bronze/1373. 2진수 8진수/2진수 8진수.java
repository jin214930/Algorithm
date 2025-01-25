import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        int tmp = 1, sum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (tmp == 8) {
                tmp = 1;
                sb.insert(0, sum);
                sum = 0;
            }
            sum += tmp * (s.charAt(i) - '0');
            tmp *= 2;
        }
        
        sb.insert(0, sum);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}