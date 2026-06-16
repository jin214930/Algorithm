import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        String p = st.nextToken();
        
        bw.write(s.substring(0, 2));
        bw.write(p.substring(2));

        bw.flush();
    }
}
