import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int i = a;
        while (i <= b) {
            bw.write(i + " ");
            if (i % 2 == 0) {
                i += 3;
            } else {
                i *= 2;
            }
        }

        bw.flush();
    }
}
