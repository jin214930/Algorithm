import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int i = 10;
        while (i <= 26) {
            bw.write(i + " ");
            i += 2;
        }

        bw.flush();
    }
}
