import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] tmp = br.readLine().split("-");
        bw.write(tmp[2] + "." + tmp[0] + "." + tmp[1]);

        bw.flush();
    }
}
