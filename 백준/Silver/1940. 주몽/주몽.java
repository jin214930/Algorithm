import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

       int n = Integer.parseInt(br.readLine());
       int m = Integer.parseInt(br.readLine());
       int[] a = new int[n];
       StringTokenizer st = new StringTokenizer(br.readLine());
       for (int i = 0; i < n; i++) {
          a[i] = Integer.parseInt(st.nextToken());
       }

       Arrays.sort(a);

       int ans = 0;
       int s = 0;
       int e = n - 1;

       while (s < e) {
          int sum = a[s] + a[e];
          
          if (sum == m) {
             ans++;
             s++;
             e--;
          } else if (sum < m) {
             s++;
          } else {
             e--;
          }
       }

       bw.write(ans + "");

       bw.flush();
       bw.close();
       br.close();
    }
}