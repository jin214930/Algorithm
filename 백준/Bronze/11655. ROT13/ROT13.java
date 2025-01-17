import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c >= 'n' && c <= 'z' || c >= 'N' && c <= 'Z')
                sb.append((char) (c - 13));
            else if (c >= 'a' && c < 'n' || c >= 'A' && c < 'N')
                sb.append((char) (c + 13));
            else
                sb.append(c);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
