import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++)
            q.add(i);

        List<Integer> list = new ArrayList<>();
        while (!q.isEmpty()) {
            for (int i = 0; i < m - 1; i++)
                q.add(q.poll());
            list.add(q.poll());
        }

        bw.write("<");
        for (int i = 0; i < list.size() - 1; i++)
            bw.write(list.get(i) + ", ");
        bw.write(list.get(list.size() - 1) + ">");

        bw.flush();
        br.close();
        bw.close();
    }
}
