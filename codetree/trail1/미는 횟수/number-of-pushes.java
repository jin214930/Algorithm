import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine();
        String b = br.readLine();

        for (int i = 0; i < a.length(); i++) {
            a = a.charAt(a.length() - 1) + a.substring(0, a.length() - 1);
            if (a.equals(b)) {
                bw.write(i + 1 + "");
                bw.flush();
                return;
            }
        }
        bw.write("-1");

        bw.flush();
    }
}
