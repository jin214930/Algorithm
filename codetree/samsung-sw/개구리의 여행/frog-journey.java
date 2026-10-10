import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int y, x, k, cost;
        
        public Node(int y, int x, int k, int cost) {
            this.y = y;
            this.x = x;
            this.k = k;
            this.cost = cost;
        }
    }
    
    static int n;
    static char[][] map;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        
        int q = Integer.parseInt(br.readLine());
        while(q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sy = Integer.parseInt(st.nextToken()) - 1;
            int sx = Integer.parseInt(st.nextToken()) - 1;
            int ey = Integer.parseInt(st.nextToken()) - 1;
            int ex = Integer.parseInt(st.nextToken()) - 1;
            
            int[][][] d = new int[n][n][6];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    Arrays.fill(d[i][j], Integer.MAX_VALUE);
                }
            }
            
            PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.cost - n2.cost);
            d[sy][sx][1] = 0;
            pq.offer(new Node(sy, sx, 1, 0));
            
            while(!pq.isEmpty()) {
                Node cur = pq.poll();
                
                if (d[cur.y][cur.x][cur.k] < cur.cost) continue;
                
                jump(cur, cur.k, 1, d, pq);
                
                if (cur.k < 5) {
                    int nk = cur.k + 1;
                    int nextCost = cur.cost + nk * nk;
                    
                    if (d[cur.y][cur.x][nk] > nextCost) {
                        d[cur.y][cur.x][nk] = nextCost;
                        pq.add(new Node(cur.y, cur.x, nk, nextCost));
                    }
                }
                
                for (int nk = 1; nk < cur.k; nk++) {
                    int nextCost = cur.cost + 1;
                    
                    if (d[cur.y][cur.x][nk] > nextCost) {
                        d[cur.y][cur.x][nk] = nextCost;
                        pq.offer(new Node(cur.y, cur.x, nk, nextCost));
                    }
                }
            }
            
            
            int ans = Integer.MAX_VALUE;
            for (int i = 1; i <= 5; i++) {
                ans = Math.min(ans, d[ey][ex][i]);
            }
            
            bw.write(ans == Integer.MAX_VALUE ? "-1\n" : ans + "\n");
        }
        
        bw.flush(); 
    }
    
    static void jump(Node cur, int nk, int cost, int[][][] d, PriorityQueue<Node> pq) {
        for (int i = 0; i < 4; i++) {
            int ny = cur.y + dy[i] * nk;
            int nx = cur.x + dx[i] * nk;
            
            if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
            if (map[ny][nx] == 'S') continue;
            
            boolean isSnake = false;
            for (int step = 1; step <= nk; step++) {
                int ty = cur.y + dy[i] * step;
                int tx = cur.x + dx[i] * step;
                
                if (map[ty][tx] == '#') {
                    isSnake = true;
                    break;
                }
            }
            
            if (isSnake) continue;
            
            int nextCost = cur.cost + cost;
            
            if (d[ny][nx][nk] > nextCost) {
                d[ny][nx][nk] = nextCost;
                pq.offer(new Node(ny, nx, nk, nextCost));
            }
        }
    }
}
