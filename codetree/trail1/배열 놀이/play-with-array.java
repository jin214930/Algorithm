import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int x, y;
            switch (cmd) {
                case 1:
                    x = Integer.parseInt(st.nextToken()) - 1;
                    bw.write(a[x] + "\n");
                    break;
                case 2:
                    x = Integer.parseInt(st.nextToken());
                    int idx = 0;
                    for (int i = 0; i < n; i++) {
                        if (a[i] == x) {
                            idx = i + 1;
                            break;
                        }
                    }
                    bw.write(idx + "\n");
                    break;
                case 3:
                    x = Integer.parseInt(st.nextToken()) - 1;
                    y = Integer.parseInt(st.nextToken()) - 1;
                    for (int i = x; i <= y; i++) {
                        bw.write(a[i] + " ");
                    }
                    bw.write("\n");
                    break;
            }
        }

        bw.flush();
    }
}
