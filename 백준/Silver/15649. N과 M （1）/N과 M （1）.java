import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static boolean[] visited;

    static void go(List<Integer> list) {
        if (list.size() == m) {
            for (int i : list)
                System.out.print(i + " ");
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;
            list.add(i);
            visited[i] = true;
            go(list);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];

        go(new ArrayList<>());

        br.close();
    }
}