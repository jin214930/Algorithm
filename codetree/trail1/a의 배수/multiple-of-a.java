import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());

        int i = 1;
        while (i <= n) {
            if (i % a == 0) {
                bw.write("1\n");
            } else {
                bw.write("0\n");
            }
            i++;
        }

        bw.flush();
    }
}
