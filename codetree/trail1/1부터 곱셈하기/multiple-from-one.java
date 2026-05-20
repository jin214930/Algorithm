import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        
        int ret = 1;
        for (int i = 1; i <= 10; i++) {
            ret *= i;
            if (ret >= n) {
                bw.write(i + "");
                break;
            }
        }

        bw.flush();
    }
}
