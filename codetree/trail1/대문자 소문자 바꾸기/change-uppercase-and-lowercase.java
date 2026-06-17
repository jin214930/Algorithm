import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                bw.write(Character.toLowerCase(c));
            } else {
                bw.write(Character.toUpperCase(c));
            }
        }

        bw.flush();
    }
}
