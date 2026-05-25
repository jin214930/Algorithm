import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        while(true) {
            if (n >= 1000) {
                break;
            }
            
            if (n % 2 == 0) {
                n = n * 3 + 1;
            } else {
                n = n * 2 + 2;
            }
            ans++;
        }
        
        bw.write(ans + "");

        bw.flush();
    }
}
