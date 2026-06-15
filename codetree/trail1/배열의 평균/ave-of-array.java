import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] rowSum = new int[2];
        int[] colSum = new int[4];
        int total = 0;

        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int x = Integer.parseInt(st.nextToken());
                rowSum[i] += x;
                colSum[j] += x;
                total += x;
            }
        }

        for (int i = 0; i < 2; i++) {
            bw.write(String.format("%.1f ", rowSum[i] / 4.0));
        }
        bw.write("\n");
        for (int i = 0; i < 4; i++) {
            bw.write(String.format("%.1f ", colSum[i] / 2.0));
        }
        bw.write("\n");
        bw.write(String.format("%.1f ", total / 8.0));

        bw.flush();
    }
}
