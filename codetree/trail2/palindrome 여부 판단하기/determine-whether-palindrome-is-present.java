import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String s = br.readLine();
        StringBuilder sb = new StringBuilder(s);
        bw.write(s.equals(sb.reverse().toString()) ? "Yes" : "No");

        bw.flush();
    }
}
