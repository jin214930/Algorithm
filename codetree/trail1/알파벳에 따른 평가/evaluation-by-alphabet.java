import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String s = br.readLine();
        
        if (s.equals("S")) {
            bw.write("Superior");
        } else if (s.equals("A")) {
            bw.write("Excellent");
        } else if (s.equals("B")) {
            bw.write("Good");
        } else if (s.equals("C")) {
            bw.write("Usually");
        } else if (s.equals("D")) {
            bw.write("Effort");
        } else {
            bw.write("Failure");
        }

        bw.flush();
    }
}
