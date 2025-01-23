import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        StringBuilder sb = new StringBuilder();

        int tmp1 = 1, tmp2 = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (tmp1 == 8) {
                tmp1 = 1;
                sb.insert(0, tmp2);
                tmp2 = 0;
            }
            if (s.charAt(i) == '1')
                tmp2 += tmp1;

            tmp1 *= 2;
        }
        sb.insert(0, tmp2);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}