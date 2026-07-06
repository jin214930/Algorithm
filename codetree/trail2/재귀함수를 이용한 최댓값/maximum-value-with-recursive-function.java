import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 0;
        for  (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            ans = Math.max(ans, x);
        }
        bw.write(ans + "");

        bw.flush();
    }
}