import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<String> list = new ArrayList<>();
        while (true) {
            String s = br.readLine();
            if (s.equals("0")) break;
            list.add(s);
        }

        bw.write(list.size() + "\n");
        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 0) bw.write(list.get(i) + "\n");
        }

        bw.flush();
    }
}
