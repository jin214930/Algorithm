import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);
        
        if (a.length != b.length) {
            bw.write("No");
            bw.flush();
            return;
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                bw.write("No");
                bw.flush();
                return;
            }
        }
        bw.write("Yes");

        bw.flush();
    }
}