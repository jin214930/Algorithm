import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String s = st.nextToken();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String p = br.readLine();
            if (s.equals(p)) cnt++;
        }

        bw.write(cnt + "");

        bw.flush();
    }
}
