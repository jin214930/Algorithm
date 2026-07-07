import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n  = Integer.parseInt(br.readLine());
        String[] a = new  String[n];
        for (int i = 0; i < n; i++) {
            a[i] = br.readLine();
        }
        
        Arrays.sort(a);
        for (int i = 0; i < n; i++) {
            bw.write(a[i] + "\n");
        }

        bw.flush();
    }
}