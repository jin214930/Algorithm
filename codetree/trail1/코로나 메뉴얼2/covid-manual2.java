import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int a = 0, b = 0, c = 0, d = 0;
        
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int x = Integer.parseInt(st.nextToken());
            if (s.equals("Y") && x >= 37) {
                a++;
            } else if (s.equals("N") && x >= 37) {
                b++;
            } else if (s.equals("Y") && x < 37) {
                c++;
            } else {
                d++;
            }
        }
        
        bw.write(a + " " + b + " " + c + " " + d + " ");
        if (a >= 2) {
            bw.write("E");
        }
        

        bw.flush();
    }
}
