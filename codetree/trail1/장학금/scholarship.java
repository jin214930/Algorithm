import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int middle = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        if (middle >= 90) {
            if (end >= 95) {
                bw.write("100000");
            } else if (end >= 90) {
                bw.write("50000");
            } else {
                bw.write("0");
            }
        } else {
            bw.write("0");
        }

        bw.flush();
    }
}
