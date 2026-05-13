import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] a = {"", "John", "Tom",  "Paul"};
        
        int n = Integer.parseInt(br.readLine());
        if (n > 3) {
            bw.write("Vacancy");
        } else {
            bw.write(a[n]);
        }

        bw.flush();
    }
}
