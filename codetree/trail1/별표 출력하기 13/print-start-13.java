import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int tmp1 = n, tmp2 = 1;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            if (i % 2 == 0) {
                for (int j = 0; j < tmp1; j++) sb.append("* ");
                tmp1--;
            } else {
                for (int j = 0; j < tmp2; j++) sb.append("* ");
                tmp2++;
            }
            list.add(sb.toString());
        }

        for (int i = 0; i < list.size(); i++) {
            bw.write(list.get(i) + "\n");
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            bw.write(list.get(i) + "\n");
        }

        bw.flush();
    }
}