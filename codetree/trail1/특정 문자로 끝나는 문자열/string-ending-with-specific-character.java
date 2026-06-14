import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] a = new String[10];
        for (int i = 0; i < 10; i++) {
            a[i] = br.readLine();
        }

        char c = br.readLine().charAt(0);

        boolean flag = false;
        for (int i = 0; i < 10; i++) {
            if (a[i].charAt(a[i].length() - 1) == c) {
                bw.write(a[i] + "\n");
                flag = true;
            }
        }
        
        if (!flag) bw.write("None");

        bw.flush();
    }
}
