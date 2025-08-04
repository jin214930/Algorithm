import java.io.*;
import java.util.*;

class Node {
    int x;
    int c;

    Node(int x, int c) {
        this.x = x;
        this.c = c;
    }
}

class Node2 {
    int x;
    int c;
    int t;

    Node2(int x, int c, int t) {
        this.x = x;
        this.c = c;
        this.t = t;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) * 2;

            graph.get(a).add(new Node(b, d));
            graph.get(b).add(new Node(a, d));
        }

        // 여우 이동
        int[] dist1 = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dist1[i] = Integer.MAX_VALUE;
        }
        dist1[1] = 0;

        PriorityQueue<Node> pq1 = new PriorityQueue<>((a, b) -> a.c - b.c);
        pq1.add(new Node(1, 0));

        while (!pq1.isEmpty()) {
            Node node = pq1.poll();

            if (dist1[node.x] < node.c)
                continue;

            for (Node next : graph.get(node.x)) {
                if (dist1[next.x] > dist1[node.x] + next.c) {
                    dist1[next.x] = dist1[node.x] + next.c;
                    pq1.add(new Node(next.x, dist1[next.x]));
                }
            }
        }

        // 늑대 이동
        int[][] dist2 = new int[n + 1][2];
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 2; j++)
                dist2[i][j] = Integer.MAX_VALUE;
        }
        dist2[1][1] = Integer.MAX_VALUE;

        PriorityQueue<Node2> pq2 = new PriorityQueue<>((a, b) -> a.c - b.c);
        pq2.add(new Node2(1, 0, 0));

        while (!pq2.isEmpty()) {
            Node2 node = pq2.poll();

            if (dist2[node.x][node.t] < node.c)
                continue;

            for (Node next : graph.get(node.x)) {
                if (node.t == 0) {
                    int tmp = node.c + next.c / 2;
                    if (dist2[next.x][1] <= tmp)
                        continue;
                    dist2[next.x][1] = tmp;
                    pq2.add(new Node2(next.x, tmp, 1));
                } else {
                    int tmp = node.c + next.c * 2;
                    if (dist2[next.x][0] <= tmp)
                        continue;
                    dist2[next.x][0] = tmp;
                    pq2.add(new Node2(next.x, tmp, 0));
                }
            }
        }

        int ans = 0;
        for (int i = 2; i <= n; i++) {
            if (dist1[i] < Math.min(dist2[i][0], dist2[i][1]))
                ans++;
        }
        bw.write(ans + "");

        bw.flush();
        bw.close();
        br.close();
    }
}