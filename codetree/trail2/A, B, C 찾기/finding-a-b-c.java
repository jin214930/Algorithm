import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[7];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 7; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            set.add(arr[i]);
        }
        Arrays.sort(arr);
        int a = arr[0];
        for (int i = 1; i < 4; i++) {
            for (int j = i + 1; j < 5; j++) {
                int b = arr[i];
                int c = arr[j];
                if (set.contains(a + b) && set.contains(a + c) && b + c == arr[5]) {
                    bw.write(a + " " + b + " " + c);
                    bw.flush();
                    return;
                }
            }
        }

        bw.flush();
    }
}