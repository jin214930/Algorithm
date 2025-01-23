import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] d = new int[13];
        d[0] = 1;
        for (int i = 1; i < 13; i++)
            d[i] = d[i - 1] * i;

        int n = Integer.parseInt(br.readLine());
        
        bw.write(d[n] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

