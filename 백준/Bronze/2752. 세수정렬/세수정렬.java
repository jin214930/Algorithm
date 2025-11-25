import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[3];
        for (int i = 0; i < 3; i++)
            a[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(a);

        for (int i : a)
            bw.write(i + " ");

        bw.flush();
        bw.close();
        br.close();
    }
}