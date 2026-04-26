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

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (sum - a[i] - a[j] == 100) {
                    for (int k = 0; k < a.length; k++) {
                        if (k != i && k != j) {
                            bw.write(a[k] + "\n");
                        }
                    }

                    bw.flush();
                    return;
                }
            }
        }
    }
}
