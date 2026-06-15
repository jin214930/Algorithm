import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int tmp = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(tmp++ + " ");
            }
            bw.newLine();
        }


        bw.flush();
    }
}
