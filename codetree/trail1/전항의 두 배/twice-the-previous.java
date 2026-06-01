import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a =  Integer.parseInt(st.nextToken());
        int b =  Integer.parseInt(st.nextToken());
        
        bw.write(a + " " + b + " ");
        for (int i = 0; i < 8; i++) {
            int tmp= b;
            b = b + 2 * a;
            a = tmp;
            bw.write(b + " ");
        }

        bw.flush();
    }
}
