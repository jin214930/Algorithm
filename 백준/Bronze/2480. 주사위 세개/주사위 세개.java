import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int money;
        if (a == b && b == c)
            money = 10000 + a * 1000;
        else if (a == b || b == c)
            money = 1000 + b * 100;
        else if (a == c)
            money = 1000 + a * 100;
        else
            money = 100 * Math.max(Math.max(a, b), c);

        bw.write(money + "");

        bw.flush();
        bw.close();
        br.close();
    }
}