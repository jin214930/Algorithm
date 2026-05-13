import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        double n = Double.parseDouble(br.readLine());
        
        if (n >= 1.0) {
            bw.write("High");
        } else if (n >= 0.5) {
            bw.write("Middle");
        } else {
            bw.write("Low");
        }

        bw.flush();
    }
}
