import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++)
            list.add(i);

        bw.write("<");
        while (!list.isEmpty()) {
            for (int i = 0; i < k - 1; i++)
                list.add(list.poll());

            bw.write(list.poll() + "");

            if (!list.isEmpty())
                bw.write(", ");
        }
        bw.write(">");

        bw.flush();
        bw.close();
        br.close();
    }
}