import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[f + 1];
        q.add(s);
        visited[s] = 1;

        while (!q.isEmpty()) {
            int x = q.poll();
            for (int nx : new int[]{x + u, x - d}) {
                if (nx <= 0 || nx > f || visited[nx] != 0) continue;
                q.add(nx);
                visited[nx] = visited[x] + 1;
            }
        }

        if (visited[g] == 0)
            bw.write("use the stairs");
        else
            bw.write((visited[g] - 1) + "");

        bw.flush();
        bw.close();
        br.close();
    }
}