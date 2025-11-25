import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++)
            q.add(i);

        bw.write("<");
        while (!q.isEmpty()) {
            for (int i = 0; i < k - 1; i++)
                q.add(q.poll());

            bw.write(q.poll() + "");

            if (!q.isEmpty())
                bw.write(", ");
        }
        bw.write(">");

        bw.flush();
        bw.close();
        br.close();
    }
}