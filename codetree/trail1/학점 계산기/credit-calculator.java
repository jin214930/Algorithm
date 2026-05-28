import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        double sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sum += Double.parseDouble(st.nextToken());
        }

        double avg = sum / n;
        bw.write(String.format("%.1f\n", avg));
        if (avg >= 4.0) {
            bw.write("Perfect");
        } else if (avg >= 3.0) {
            bw.write("Good");
        } else {
            bw.write("Poor");
        }

        bw.flush();
    }
}
