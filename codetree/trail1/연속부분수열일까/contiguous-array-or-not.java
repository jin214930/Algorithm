import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        br.readLine();
        String s = br.readLine();
        String p = br.readLine();
        bw.write(s.contains(p) ? "Yes" : "No");

        bw.flush();
    }
}
