import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        
        int sum = 0;
        for (int i = 1; i < n;i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        
        bw.write(sum == n ? "P" : "N");

        bw.flush();
    }
}
