import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++)
                bw.write(" ");
            for (int j = n; j > i; j--)
                bw.write("*");
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}