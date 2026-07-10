import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[15];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 15; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int a = arr[0];
        int b = arr[1];
        int c = arr[2];
        int d = arr[14] - a - b - c;
        bw.write(a + " " + b + " " + c + " " + d + "\n");

        bw.flush();
    }
}