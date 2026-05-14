import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int a= Integer.parseInt(br.readLine());
        
        if (a >= 10 && a <= 20) {
            bw.write("yes");
        } else {
            bw.write("no");
        }

        bw.flush();
    }
}
