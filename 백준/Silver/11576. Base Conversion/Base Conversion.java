import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        int tmp = (int) Math.pow(a, m - 1);
        int a_10 = 0;
        st = new StringTokenizer(br.readLine());
        while (m-- > 0) {
            a_10 += tmp * Integer.parseInt(st.nextToken());
            tmp /= a;
        }

        List<Integer> list = new ArrayList<>();
        while (a_10 != 0) {
            list.add(a_10 % b);
            a_10 /= b;
        }

        for (int i = list.size() - 1; i >= 0; i--)
            bw.write(list.get(i) + " ");


        bw.flush();
        bw.close();
        br.close();
    }
}