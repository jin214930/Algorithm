import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String[] a = new String[n];
        for (int i = 0; i < n; i++)
            a[i] = br.readLine();

        Arrays.sort(a, (s1, s2) -> {
            if (s1.length() == s2.length()) {
                int sum1 = 0;
                int sum2 = 0;

                for (char c : s1.toCharArray()) {
                    if (c >= '0' && c <= '9')
                        sum1 += c - '0';
                }

                for (char c : s2.toCharArray()) {
                    if (c >= '0' && c <= '9')
                        sum2 += c - '0';
                }

                if (sum1 == sum2)
                    return s1.compareTo(s2);
                return sum1 - sum2;
            }

            return s1.length() - s2.length();
        });

        for (String s : a)
            bw.write(s + "\n");

        bw.flush();
    }
}