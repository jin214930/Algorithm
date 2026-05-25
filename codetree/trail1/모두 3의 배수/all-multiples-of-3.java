import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        for (int i = 0; i < 5; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x % 3 != 0) {
                bw.write("0");
                bw.flush();
                return;
            }
        }

        bw.write("1");
        bw.flush();
    }
}
