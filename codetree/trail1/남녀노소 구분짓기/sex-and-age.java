import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int gender = Integer.parseInt(br.readLine());
        int age = Integer.parseInt(br.readLine());
        
        if (gender == 0) {
            bw.write(age >= 19 ? "MAN" : "BOY");
        } else {
            bw.write(age >= 19 ? "WOMAN" : "GIRL");
        }
        
        bw.flush();
    }
}
