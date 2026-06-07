import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] a = {'L', 'E', 'B', 'R', 'O', 'S'};
        String s = br.readLine();
        for (int i = 0; i < a.length; i++) {
            if (s.charAt(0) == a[i]) {
                bw.write(i + "");
                bw.flush();
                return;
            }
        }
        
        bw.write("None");
        bw.flush();
    }
}
