import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 3; i++) {
            int cnt0 = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                if (st.nextToken().equals("0"))
                    cnt0++;
            }

            switch (cnt0) {
                case 0:
                    bw.write("E\n");
                    break;
                case 1:
                    bw.write("A\n");
                    break;
                case 2:
                    bw.write("B\n");
                    break;
                case 3:
                    bw.write("C\n");
                    break;
                default:
                    bw.write("D\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}