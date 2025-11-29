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
        int[] prev = new int[200001];
        q.add(n);
        visited[n] = 1;
        prev[n] = -1;

        while (!q.isEmpty()) {
            int x = q.poll();

            if (x == k)
                break;

            for (int nx : new int[]{2 * x, x - 1, x + 1}) {
                if (nx < 0 || nx > 200000 || visited[nx] != 0) continue;
                q.add(nx);
                visited[nx] = visited[x] + 1;
                prev[nx] = x;
            }
        }

        bw.write((visited[k] - 1) + "\n");

        List<Integer> list = new ArrayList<>();
        int tmp = prev[k];
        list.add(k);
        while (tmp != -1) {
            list.add(tmp);
            tmp = prev[tmp];
        }

        for (int i = list.size() - 1; i >= 0; i--)
            bw.write(list.get(i) + " ");

        bw.flush();
        bw.close();
        br.close();
    }
}