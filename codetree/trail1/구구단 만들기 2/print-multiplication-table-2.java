import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        for (int i = 2; i <= 8; i += 2) {
            for (int j = b; j >= a; j--) {
                bw.write(String.format("%d * %d = %d", j, i, j * i));
                if (j != a) bw.write(" / ");
            }
            bw.write("\n");
        }

        bw.flush();
    }
}