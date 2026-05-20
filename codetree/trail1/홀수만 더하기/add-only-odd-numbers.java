import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x % 2 == 1 && x % 3 == 0) {
                sum += x;
            }
        }

        bw.write(sum + "");

        bw.flush();
    }
}
