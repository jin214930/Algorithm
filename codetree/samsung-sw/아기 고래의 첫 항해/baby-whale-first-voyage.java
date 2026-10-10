import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int y, x;
        
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    static class Dest {
        Node node;
        int d;
        
        public Dest(Node node, int d) {
            this.node = node;
            this.d = d;
        }
    }
    
    static int n, y, x, d;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[] dir = {2, 1, 3, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken()) - 1;
        x = Integer.parseInt(st.nextToken()) - 1;
        d = Integer.parseInt(st.nextToken()) - 1;
        
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        visited = new boolean[n][n];
        while (true) {
            visited[y][x] = true;
            bw.write((y + 1) + " " + (x + 1) + "\n");
            
            // 인접 탐험
            boolean canMoveAdj = false;
            for (int i = 0; i < 4; i++) {
                int nd = getNextD(d, i);
                int ny = y + dy[nd];
                int nx = x + dx[nd];
                if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
                if (map[ny][nx] == 1 || visited[ny][nx]) continue;
                y = ny;
                x = nx;
                d = nd;
                canMoveAdj = true;
                break;
            }
            
            if (canMoveAdj) continue;
            
            // 가까운 바다 이동
            
            Dest dest = getDest(y, x);
            if (dest == null) break;
            y = dest.node.y;
            x = dest.node.x;
            d = dest.d;
        }
        
        bw.flush(); 
    }
    
    static int getNextD(int d, int idx) {
        if (idx == 1) {
            if (d == 0) return 2;
            if (d == 1) return 3;
            if (d == 2) return 1;
            if (d == 3) return 0;
        }
        
        if (idx == 2) {
            if (d == 0) return 3;
            if (d == 1) return 2;
            if (d == 2) return 0;
            if (d == 3) return 1;
        }
        
        if (idx == 3) {
            if (d == 0) return 1;
            if (d == 1) return 0;
            if (d == 2) return 3;
            if (d == 3) return 2;
        }
        
        return d;
    }
    
    static Dest getDest(int y, int x) {
        int[][] dist = new int[n][n];
        Queue<Node> q = new LinkedList<>();
        int[][] lastDir = new int[n][n];
        
        dist[y][x] = 1;
        q.offer(new Node(y, x));
        
        while (!q.isEmpty()) {
            Node cur = q.poll();
            
            for (int d : dir) {
                int ny = cur.y + dy[d];
                int nx = cur.x + dx[d];
                if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
                if (map[ny][nx] == 1 || dist[ny][nx] != 0) continue;
                dist[ny][nx] = dist[cur.y][cur.x] + 1;
                q.offer(new Node(ny, nx));
                lastDir[ny][nx] = d;
            }
        }
        
        Node next = null;
        int minD = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] > 1 && !visited[i][j] && minD > dist[i][j]) {
                    next = new Node(i, j);
                    minD = dist[i][j];
                }
            }
        }
        
        if (next == null) return null;
        
        return new Dest(next, lastDir[next.y][next.x]);
    }
}
