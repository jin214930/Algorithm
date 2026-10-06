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
    
    static int n, k, l;
    static int[][] map;
    static List<Node> cleaners = new ArrayList<>();
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            cleaners.add(new Node(y, x));
            map[y][x] = 1000;
        }
        
        while(l-- > 0) {
            move();
            
            clean();
            
            dustAcc();
            
            dustSpread();
            
            int sum = 0; 
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == -1) continue;
                    sum += map[i][j] % 1000;
                }
            }
            
            bw.write(sum + "\n");
            
            if (sum == 0) break;
        }
        
        bw.flush(); 
    }
    
    static void move() {
        for (Node cleaner : cleaners) {
            Node dest = getClosestDust(cleaner);
            if (dest == null) continue;
            map[cleaner.y][cleaner.x] -= 1000;
            cleaner.y = dest.y;
            cleaner.x = dest.x;
            map[cleaner.y][cleaner.x] += 1000;
        }
    }
    
    static Node getClosestDust(Node cleaner) {
        if (map[cleaner.y][cleaner.x] != 1000) return cleaner;

        Queue<Node> q = new LinkedList<>();
        int[][] visited = new int[n][n];
        q.offer(cleaner);
        visited[cleaner.y][cleaner.x] = 1;
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
                if (visited[ny][nx] != 0 || map[ny][nx] == -1 || map[ny][nx] >= 1000) continue;
                q.offer(new Node(ny, nx));
                visited[ny][nx] = visited[cur.y][cur.x] + 1;
            }
        }
        
        int minD = Integer.MAX_VALUE;
        Node dest = null;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] > 0 && map[i][j] < 1000 && visited[i][j] > 0 && minD > visited[i][j]) {
                    dest = new Node(i, j);
                    minD = visited[i][j];
                }
            }
        }
        
        return dest;
    }
    
    static void clean() {
        for (Node cleaner : cleaners) {
            int y = cleaner.y;
            int x = cleaner.x;
            
            int[] sum = new int[4];
            for (int i = 0; i < 4; i++) {
                int dust1 = map[y][x] % 1000;
                
                int d2y = y + dy[i];
                int d2x = x + dx[i];
                int dust2 = getDust(d2y, d2x);
                
                int d3y = y + dy[(i + 1) % 4];
                int d3x = x + dx[(i + 1) % 4];
                int dust3 = getDust(d3y, d3x);
                
                int d4y = y + dy[(i + 3) % 4];
                int d4x = x + dx[(i + 3) % 4];
                int dust4 = getDust(d4y, d4x);
                sum[i] = Math.min(20, dust1) + Math.min(20,  dust2) + Math.min(20, dust3) + Math.min(20, dust4);
            }
            
            int max = sum[0];
            int idx = 0;
            for (int i = 1; i < 4; i++) {
                if (max < sum[i]) {
                    idx = i;
                    max = sum[i];
                }
            }
            
            int dust1 = map[y][x] % 1000;
            map[y][x] -= Math.min(20, dust1);
            
            int d2y = y + dy[idx];
            int d2x = x + dx[idx];
            cleanDust(d2y, d2x);
            
            int d3y = y + dy[(idx + 1) % 4];
            int d3x = x + dx[(idx + 1) % 4];
            cleanDust(d3y, d3x);
            
            int d4y = y + dy[(idx + 3) % 4];
            int d4x = x + dx[(idx + 3) % 4];
            cleanDust(d4y, d4x);
        }
    }
    
    static int getDust(int y, int x) {
        if (y < 0 || x < 0 || y >= n || x >= n) return 0;
        
        if (map[y][x] == -1) return 0;
        
        return map[y][x] % 1000;
    }
    
    static void cleanDust(int y, int x) {
        if (y < 0 || x < 0 || y >= n || x >= n) return;
        if (map[y][x] == -1) return;
        
        int dust = map[y][x] % 1000;
        map[y][x] -= Math.min(20, dust);
    }
    
    static void dustAcc() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] <= 0 || map[i][j] == 1000) continue;
                map[i][j] += 5;
            }
        }
    }
    
    static void dustSpread() {
        int[][] sum = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0 || map[i][j] == 1000) {
                    for (int d = 0; d < 4; d++) {
                        int ny = i + dy[d];
                        int nx = j + dx[d];
                        if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
                        if (map[ny][nx] <= 0) continue;
                        sum[i][j] += map[ny][nx] % 1000;
                    }
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (sum[i][j] != 0) map[i][j] += sum[i][j] / 10;
            }
        }
    }
}
