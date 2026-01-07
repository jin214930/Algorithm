import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long[] a = new long[n];

        while (n > 0) {
            while (st.hasMoreTokens()) {
                String s = st.nextToken();
                String reversed = new StringBuilder(s).reverse().toString();
                a[--n] = Long.parseLong(reversed);
            }
            if (n > 0)
                st = new StringTokenizer(br.readLine());
        }

        Arrays.sort(a);
        for (long l : a)
            bw.write(l + "\n");

        bw.flush();
    }
}