import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        for (int i = 1; i <= 19; i++) {
            for (int j = 1; j <= 19; j++) {
                bw.write(String.format("%d * %d = %d", i, j, i * j));
                if (j % 2 == 0 || j == 19) bw.write("\n");
                else bw.write(" / ");
            }
        }

        bw.flush();
    }
}