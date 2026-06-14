import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] a = br.readLine().split(" ");
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) bw.write(a[i] + "\n");
        }

        bw.flush();
    }
}
