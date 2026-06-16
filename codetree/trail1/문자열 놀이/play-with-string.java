import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        int q = Integer.parseInt(st.nextToken());

        char[] a = s.toCharArray();

        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                char tmp = a[x - 1];
                a[x - 1] = a[y - 1];
                a[y - 1] = tmp;
            } else {
                char x = st.nextToken().charAt(0);
                char y = st.nextToken().charAt(0);
                for (int i = 0; i < s.length(); i++) {
                    if (a[i] == x) a[i] = y;
                }
            }
            for (char c : a) {
                bw.write(c);
            }
            bw.newLine();
        }


        bw.flush();
    }
}
