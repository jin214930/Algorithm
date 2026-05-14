import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int a = Integer.parseInt(br.readLine());
        
        bw.write(a % 3 == 0 ? "YES" : "NO");
        bw.newLine();
        bw.write(a % 5 == 0 ? "YES" : "NO");

        bw.flush();
    }
}
