import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        String[][] arr = new String[9][(b - a) / 2 + 1];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                int tmp = b - 2 * j;
                arr[i][j] = String.format("%d * %d = %d", tmp, i + 1, tmp * (i + 1));
            }
        }
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                bw.write(arr[i][j]);
                if (j != arr[0].length - 1) bw.write(" / ");
            }
            bw.newLine();
        }

        bw.flush();
    }
}