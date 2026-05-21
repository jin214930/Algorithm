import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        if (n % 2 == 0) {
            int tmp = 0;
            while(n != 0) {
                tmp += n % 10;
                n /= 10;
            }
            if (tmp % 5 == 0) {
                bw.write("Yes");
                bw.flush();
                return;
            }
        }
        bw.write("No");

        bw.flush();
    }

}
