import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            // x1보다 크거나 같은 가장 작은 값의 인덱스
            int s = 0, e = n - 1;
            int idx1 = n;
            while (s <= e) {
                int mid = (s + e) / 2;
                if (a[mid] >= x1) {
                    e = mid - 1;
                    idx1 = mid;
                } else {
                    s = mid + 1;
                }
            }

            // x2보다 작거나 같은 가잔 큰 값의 인덱스
            s = 0;
            e = n - 1;
            int idx2 = -1;
            while (s <= e) {
                int mid = (s + e) / 2;
                if (a[mid] <= x2) {
                    s = mid + 1;
                    idx2 = mid;
                } else {
                    e = mid - 1;
                }
            }

            if (idx1 > idx2) {
                bw.write("0\n");
            } else {
                bw.write(idx2 - idx1 + 1 + "\n");
            }
        }

        bw.flush();
    }
}
