import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] arr = br.readLine().toCharArray();

        for (char c : arr) {
            bw.write(c);
        }
        bw.newLine();

        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int idx = (len - i - 1 + j) % len;
                bw.write(arr[idx]);
            }
            bw.newLine();
        }

        bw.flush();
    }
}
