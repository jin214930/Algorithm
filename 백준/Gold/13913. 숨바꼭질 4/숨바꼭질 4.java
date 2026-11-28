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
        int[] pre = new int[200001];
        Arrays.fill(pre, -1);

        q.offer(n);
        visited[n] = 1;

        while (!q.isEmpty()) {
            int x = q.poll();

            if (x == k)
                break;

            for (int nx : new int[] { x - 1, x + 1, 2 * x }) {
                if (nx < 0 || nx > 200000 || visited[nx] != 0)
                    continue;
                q.offer(nx);
                visited[nx] = visited[x] + 1;
                pre[nx] = x;
            }
        }

        bw.write((visited[k] - 1) + "\n");

        List<Integer> list = new ArrayList<>();
        while (k != -1) {
            list.add(k);
            k = pre[k];
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            bw.write(list.get(i) + " ");
        }

        bw.flush();
    }
}
