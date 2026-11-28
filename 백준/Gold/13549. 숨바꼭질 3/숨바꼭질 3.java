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
        int[] visited = new int[200001];

        q.offer(n);
        visited[n] = 1;

        while (!q.isEmpty()) {
            int x = q.poll();

            if (x == k)
                break;

            for (int nx = 2 * x; nx <= 200000; nx *= 2) {
                if (visited[nx] != 0)
                    break;
                q.offer(nx);
                visited[nx] = visited[x];
            }

            for (int nx : new int[] { x - 1, x + 1 }) {
                if (nx < 0 || nx > 200000 || visited[nx] != 0)
                    continue;
                q.offer(nx);
                visited[nx] = visited[x] + 1;
            }
        }

        bw.write((visited[k] - 1) + "");

        bw.flush();
    }
}
