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

        String ans = sb.toString();
        while (ans.startsWith("0") && ans.length() != 1) {
            ans = ans.substring(1);
        }

        bw.write(ans);
        bw.flush();
        bw.close();
        br.close();
    }
}