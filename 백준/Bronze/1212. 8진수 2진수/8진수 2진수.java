import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] a = {"000", "001", "010", "011", "100", "101", "110", "111"};


        String s = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray())
            sb.append(a[c - '0']);

        while (sb.charAt(0) == '0' && sb.length() != 1)
            sb.deleteCharAt(0);

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
