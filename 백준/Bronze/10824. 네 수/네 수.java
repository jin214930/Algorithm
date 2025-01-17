import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s1 = st.nextToken() + st.nextToken();
        String s2 = st.nextToken() + st.nextToken();

        long ans = Long.parseLong(s1) + Long.parseLong(s2);

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
