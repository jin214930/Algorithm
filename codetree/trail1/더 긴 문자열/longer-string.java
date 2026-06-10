import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        String t = st.nextToken();
        if (s.length() == t.length()) {
            bw.write("same");
        } else if (s.length() > t.length()) {
            bw.write(s + " " + s.length());
        } else {
            bw.write(t + " " + t.length());
        }

        bw.flush();
    }
}
