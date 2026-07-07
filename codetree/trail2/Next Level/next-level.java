import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write("user codetree lv 10\n");
        StringTokenizer st = new StringTokenizer(br.readLine());
        bw.write("user " + st.nextToken() + " lv " + st.nextToken() + "\n");

        bw.flush();
    }
}