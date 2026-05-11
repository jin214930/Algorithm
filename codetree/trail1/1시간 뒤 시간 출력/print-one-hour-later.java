import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = br.readLine().split(":");

        int h = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        
        bw.write(h + 1 + ":" + m);

        bw.flush();
    }
}
