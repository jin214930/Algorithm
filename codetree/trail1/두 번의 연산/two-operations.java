import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        if (a % 2 == 1) {
            a += 3;
        }
        
        if (a % 3 == 0) {
            a /= 3;
        }
        
        bw.write(a + "");

        bw.flush();
    }
}
