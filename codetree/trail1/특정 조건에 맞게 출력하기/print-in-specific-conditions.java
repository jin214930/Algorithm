import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int x = Integer.parseInt(st.nextToken());
            if (x == 0) {
                break;
            }

            if (x % 2 == 0) {
                bw.write(x / 2 + " ");
            } else {
                bw.write(x + 3 + " ");
            }
        }

        bw.flush();
    }
}
