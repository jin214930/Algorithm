import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        
        int x = 0;
        int tmp = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            x += tmp * (s.charAt(i) - '0');
            tmp *= a;
        }
        
        StringBuilder sb = new StringBuilder();
        while(x != 0) {
            sb.append(x % b);
            x /= b;
        }
        
        bw.write(sb.reverse().toString());

        bw.flush();
    }
}