import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++)
            set.add(br.readLine());

        List<String> list = new ArrayList<>(set);

        Collections.sort(list, (s1, s2) -> {
            if (s1.length() == s2.length())
                return s1.compareTo(s2);
            return s1.length() - s2.length();
        });

        for (String s : list)
            bw.write(s + "\n");
        
        bw.flush();
    }
}