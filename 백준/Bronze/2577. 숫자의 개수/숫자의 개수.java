import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int ret = a * b * c;

        int[] cnt = new int[10];
        while (ret > 0) {
            cnt[ret % 10]++;
            ret /= 10;
        }

        for (int i : cnt)
            bw.write(i + "\n");


        bw.flush();
        bw.close();
        br.close();
    }
}