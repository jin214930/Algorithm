import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        bw.write("code : " + st.nextToken() + "\n");
        bw.write("color : " + st.nextToken() + "\n");
        bw.write("second : " + st.nextToken() + "\n");

        bw.flush();
    }
}