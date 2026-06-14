import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int x = Integer.parseInt(br.readLine());
        for (int i = 0; i < Math.min(x, s.length()); i++) {
            bw.write(s.charAt(s.length() - 1 - i));
        }

        bw.flush();
    }
}
