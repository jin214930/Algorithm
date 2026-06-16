import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder(br.readLine());
        while (sb.length() > 1) {
            int n = Integer.parseInt(br.readLine());
            if (n >= sb.length()) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.deleteCharAt(n);
            }
            bw.write(sb.toString() + "\n");
        }

        bw.flush();
    }
}
