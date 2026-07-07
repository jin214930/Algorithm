import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] a = br.readLine().toCharArray();
        Arrays.sort(a);
        for (char c : a) bw.write(c);

        bw.flush();
    }
}