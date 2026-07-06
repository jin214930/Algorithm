import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int ans = 0;
        while (n != 1) {
            if (n % 2 == 0) n /= 2;
            else n = n * 3 + 1;
            ans++;
        }

        bw.write(ans + "");
        bw.flush();
    }
}