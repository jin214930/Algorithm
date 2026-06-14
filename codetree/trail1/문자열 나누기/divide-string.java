import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] a = br.readLine().split(" ");
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < n; i++)
            tmp.append(a[i]);

        for (int i = 0; i < tmp.length(); i++) {
            bw.write(tmp.charAt(i));
            if (i % 5 == 4) bw.write("\n");
        }

        bw.flush();
    }
}
