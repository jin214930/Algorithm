import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String a = br.readLine();
        String b = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (char c : a.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        int x = Integer.parseInt(sb.toString());

        sb.setLength(0);
        for (char c : b.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        bw.write(x + Integer.parseInt(sb.toString()) + "");

        bw.flush();
    }
}
