import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int age1 = Integer.parseInt(st.nextToken());
        String gender1 = st.nextToken();
        st = new StringTokenizer(br.readLine());
        int age2 = Integer.parseInt(st.nextToken());
        String gender2 = st.nextToken();

        if (age1 >= 19 && gender1.equals("M") || age2 >= 19 && gender2.equals("M")) {
            bw.write("1");
        } else {
            bw.write("0");
        }
        
        bw.flush();
    }
}
