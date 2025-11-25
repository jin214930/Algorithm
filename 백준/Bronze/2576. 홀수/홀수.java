import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] a = new int[7];
        for (int i = 0; i < 7; i++)
            a[i] = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < 7; i++) {
            if (a[i] % 2 == 1) {
                list.add(a[i]);
                sum += a[i];
            }
        }

        Collections.sort(list);

        if (list.isEmpty())
            bw.write("-1");
        else {
            bw.write(sum + "\n");
            bw.write(list.get(0) + "");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}