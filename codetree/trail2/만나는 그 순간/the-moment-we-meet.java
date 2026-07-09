import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] a = new int[1000001];
        int[] b = new int[1000001];
        
        int t = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String d = st.nextToken();
            int x = Integer.parseInt(st.nextToken());
            if (d.equals("R")) {
                for (int j = 0; j < x; j++) {
                    t++;
                    a[t] = a[t - 1] + 1;
                }
            } else {
                for (int j = 0; j < x; j++) {
                    t++;
                    a[t] = a[t - 1] - 1;
                }
            }
        }

        t = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String d = st.nextToken();
            int x = Integer.parseInt(st.nextToken());
            if (d.equals("R")) {
                for (int j = 0; j < x; j++) {
                    t++;
                    b[t] = b[t - 1] + 1;
                }
            } else {
                for (int j = 0; j < x; j++) {
                    t++;
                    b[t] = b[t - 1] - 1;
                }
            }
        }
        
        for (int i = 1; i < t; i++) {
            if (a[i] == b[i]) {
                bw.write(i + "");
                bw.flush();
                return;
            }
        }
        bw.write("-1");


        bw.flush();
    }
}