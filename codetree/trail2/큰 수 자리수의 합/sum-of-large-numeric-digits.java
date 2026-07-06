import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int ret = 1;
        for (int i = 0; i < 3; i++) {
            ret *= Integer.parseInt(st.nextToken());
        }
        
        int ans = 0;
        while(ret != 0) {
            ans += ret % 10;
            ret /= 10;
        }
        
        bw.write(ans + "");
        bw.flush();
    }
}