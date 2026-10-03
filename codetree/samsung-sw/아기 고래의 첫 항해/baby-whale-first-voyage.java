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
    
    static class Result {
        int y, x, d;
        
        public Result(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.d = d;
        }
    }
    
    static int n, y, x, d;
    static int[][] a;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[] moveOrder = {2, 1, 3, 0};
    static List<Node> nodes = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken()) - 1;
        x = Integer.parseInt(st.nextToken()) - 1;
        d = Integer.parseInt(st.nextToken()) - 1;
        
        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        visited = new boolean[n][n];
        while (true) {
            nodes.add(new Node(y + 1, x + 1));
            visited[y][x] = true;
            
            boolean canMoveAdj = false;
            for (int i = 0; i < 4; i++) {
                int nd = nextDir(i, d);
                int ny = y + dy[nd];
                int nx = x + dx[nd];
                if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
                if (a[ny][nx] == 1 || visited[ny][nx]) continue;
                d = nd;
                y = ny;
                x = nx;
                canMoveAdj = true;
                break;
            }
            
            if (canMoveAdj) continue;
            
            Result next = findDestination(y, x);
            
            if (next == null) break;
            
            y = next.y;
            x = next.x;
            d = next.d;
        }
        
        for (Node node : nodes) {
            bw.write(node.y + " " + node.x + "\n");
        }
        
        bw.flush(); 
    }
    
    static int nextDir(int idx, int d) {
        if (idx == 1) {
            if (d == 0) return 2;
            if (d == 1) return 3;
            if (d == 2) return 1;
            if (d == 3) return 0;
        } else if (idx == 2) {
            if (d == 0) return 3;
            if (d == 1) return 2;
            if (d == 2) return 0;
            if (d == 3) return 1;

        } else if (idx == 3) {
            if (d == 0) return 1;
            if (d == 1) return 0;
            if (d == 2) return 3;
            if (d == 3) return 2;
        }
        
        return d;
    }
    
    static Result findDestination(int y, int x) {
        Queue<Node> q = new LinkedList<>();
        int[][] dist = new int[n][n];
        int[][] lastDir = new int[n][n];
        
        
        dist[y][x] = 1;
        q.offer(new Node(y, x));
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            for (int nd : moveOrder) {
                int ny = cur.y + dy[nd];
                int nx = cur.x + dx[nd];
                
                if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
                if (a[ny][nx] == 1 || dist[ny][nx] != 0) continue;
                
                dist[ny][nx] = dist[cur.y][cur.x] + 1;
                lastDir[ny][nx] = nd;
                q.offer(new Node(ny, nx));
            }
        }
        
        int minD = Integer.MAX_VALUE;
        int ty = -1, tx = -1;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] != 0 && !visited[i][j] && dist[i][j] < minD) {
                    minD = dist[i][j];
                    ty = i;
                    tx = j;
                }
            }
        }
        
        if (ty == -1) return null;
        
        return new Result(ty, tx, lastDir[ty][tx]);
    }
}
