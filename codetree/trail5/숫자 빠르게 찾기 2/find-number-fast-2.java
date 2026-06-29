import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        TreeSet<Integer> ts = new TreeSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n;i++) {
            int x  = Integer.parseInt(st.nextToken());
            ts.add(x);
        }
        
        while(m-- > 0) {
            int x = Integer.parseInt(br.readLine());
            Integer tmp = ts.ceiling(x);
            if (tmp == null) bw.write("-1\n");
            else bw.write(tmp + "\n");
        }

        bw.flush();
    }
}
