import java.io.*;
import java.util.*;

public class Main {    
    static char[][] s = new char[4][8];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        for (int i = 0; i < 4; i++) {
            s[i] = br.readLine().toCharArray();
        }
        
        int k = Integer.parseInt(br.readLine());
        
        while (k-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());
            
            int[] rotate = new int[4];
            rotate[n] = d;
            for (int i = n; i < 3; i++) {
                if (s[i][2] != s[i + 1][6]) {
                    rotate[i + 1] = -1 * rotate[i];
                }
            }
            
            for (int i = n; i > 0; i--) {
                if (s[i][6] != s[i - 1][2]) {
                    rotate[i - 1] = -1 * rotate[i];
                }
            }
            
            for (int i = 0; i < 4; i++) {
                rotateTable(i, rotate[i]);
            }
        }
        
        int tmp = 1;
        int ans = 0;
        for (int i = 0; i < 4; i++) {
            if (s[i][0] == '1') {
                ans += tmp;
            }
            tmp *= 2;
        }
        
        bw.write(ans + "");
        bw.flush(); 
    }
    
    static void rotateTable(int n, int d) {
        if (d == 1) {
            char tmp = s[n][7];
            for (int i = 7; i > 0; i--) {
                s[n][i] = s[n][i - 1];
            }
            s[n][0] = tmp;
        } else if (d == -1) {
            char tmp = s[n][0];
            for (int i = 0; i < 7; i++) {
                s[n][i] = s[n][i + 1];
            }
            s[n][7] = tmp;
        }
    }
}
