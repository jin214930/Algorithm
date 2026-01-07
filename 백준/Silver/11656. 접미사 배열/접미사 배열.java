import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++)
            list.add(s.substring(i));

        Collections.sort(list);

        for (String str : list)
            bw.write(str + "\n");

        bw.flush();
    }
}