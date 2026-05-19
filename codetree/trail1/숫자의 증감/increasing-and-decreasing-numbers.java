import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String c = st.nextToken();
        int n = Integer.parseInt(st.nextToken());

        if (c.equals("A")) {
            for (int i = 1; i <= n; i++) {
                bw.write(i + " ");
            }
        } else {
            for (int i = n; i >= 1; i--) {
                bw.write(i + " ");
            }
        }

        bw.flush();
    }
}
