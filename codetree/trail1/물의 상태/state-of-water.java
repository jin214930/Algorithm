import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        if (n < 0) {
            bw.write("ice");
        } else if (n >= 100) {
            bw.write("vapor");
        } else {
            bw.write("water");
        }

        bw.flush();
    }
}
