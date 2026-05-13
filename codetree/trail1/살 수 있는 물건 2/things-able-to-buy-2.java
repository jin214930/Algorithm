import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        
        if (n >= 3000) {
            bw.write("book");
        } else if (n >= 1000) {
            bw.write("mask");
        } else if (n >= 500) {
            bw.write("pen");
        } else {
            bw.write("no");
        }
        
        bw.flush();
    }
}
