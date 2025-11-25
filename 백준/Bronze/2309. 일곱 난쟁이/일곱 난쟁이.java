import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] a = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            a[i] = Integer.parseInt(br.readLine());
            sum += a[i];
        }

        Arrays.sort(a);

        for (int i = 1; i < 9; i++) {
            for (int j = 0; j < i; j++) {
                if (sum - a[i] - a[j] == 100) {
                    for (int k = 0; k < 9; k++) {
                        if (k != i && k != j)
                            bw.write(a[k] + "\n");
                    }
                    bw.flush();
                    bw.close();
                    br.close();
                    return;
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}