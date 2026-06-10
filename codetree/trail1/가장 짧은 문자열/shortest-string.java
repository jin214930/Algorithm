import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(br.readLine().length());
        }

        Collections.sort(list);
        bw.write(list.get(list.size() - 1) - list.get(0) + "");

        bw.flush();
    }
}
