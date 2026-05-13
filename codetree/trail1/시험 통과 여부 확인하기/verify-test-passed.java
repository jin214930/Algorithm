import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        
        if (n >= 80) {
            bw.write("pass");
        } else {
            bw.write((80 - n) + " more score");
        }

        bw.flush();
    }
}
