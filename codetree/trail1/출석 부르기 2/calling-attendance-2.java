import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = {"", "John", "Tom", "Paul", "Sam"};
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n > 4) {
                bw.write("Vacancy\n");
                break;
            }

            bw.write(arr[n] + "\n");
        }

        bw.flush();
    }
}
