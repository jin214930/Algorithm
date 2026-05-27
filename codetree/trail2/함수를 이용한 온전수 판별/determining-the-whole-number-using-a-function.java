import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        int cnt = 0;
        for (int i = a; i <= b; i++) {
            if (check(i)) {
                cnt++;
            }
        }
        
        bw.write(cnt+"");
        bw.flush();
    }
    
    public static boolean check(int n) {
        if (n % 2 == 0) {
            return false;
        }
        if (n % 10 == 5) {
            return false;
        }
        return n % 3 != 0 || n % 9 == 0;
    }
}
