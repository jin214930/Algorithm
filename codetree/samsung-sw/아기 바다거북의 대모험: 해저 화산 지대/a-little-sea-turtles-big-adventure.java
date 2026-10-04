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
    
    static class Mountain {
        int y, x, nowP, maxP;
        
        public Mountain(int y, int x, int nowP, int maxP) {
            this.y = y;
            this.x = x;
            this.nowP = nowP;
            this.maxP = maxP;
        }
    }
    
    static int n, m, k;
    static int[][] map;
    static Node[] turtles;
    static Mountain[] mountains;
    static int[][] heat;
    static boolean[] isBomb;
    static int[] ans;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        turtles = new Node[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            turtles[i] = new Node(y, x);
            map[y][x] = 2;
        }
        
        mountains = new Mountain[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            mountains[i] = new Mountain(y, x, 0, p);
        }
        
        ans = new int[m];
        Arrays.fill(ans, -1);

        for (int t = 1; t <= 100; t++) {
            for (int i = 0; i < m; i++) {
                if (turtles[i] == null) continue;
                move(i, t);
            }
            
            pressureIncrease();
            
            heat = new int[n][n];
            isBomb = new boolean[k];
            while (true) {
                boolean flag = true;
                for (int i = 0; i < k; i++) {
                    Mountain mountain = mountains[i];
                    if (!isBomb[i] && mountain.nowP + heat[mountain.y][mountain.x] >= mountain.maxP) {
                        heat[mountain.y][mountain.x] += mountain.maxP;
                        for (int d = 0; d < 4; d++) {
                            bomb(mountain.y, mountain.x, mountain.maxP, d);
                        }
                        isBomb[i] = true;
                        flag = false;
                    }
                }
                
                
                if (flag) break;
            }
            
            for (int i = 0; i < m; i++) {
                Node turtle = turtles[i];
                if (turtle == null) continue;
                if (heat[turtle.y][turtle.x] >= 20) {
                    map[turtle.y][turtle.x] = 3;
                    turtles[i] = null;
                }
            }
            
            for (int i = 0; i < k; i++) {
                if (isBomb[i]) {
                    mountains[i].nowP = 0;
                }
            }
            
        }
        
        for (int i = 0; i < m; i++) {
            bw.write(ans[i] + "\n");
        }
        
        bw.flush(); 
    }
    
    static void move(int idx, int t) {
        Node turtle = turtles[idx];
        
        int[][] dir = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(dir[i], -1);
        
        int[][] visited = new int[n][n];
        Queue<Node> q = new LinkedList<>();
        q.offer(turtle);
        visited[turtle.y][turtle.x] = 1;
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.y == n - 1 && cur.x == n - 1) break;
            
            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
                if (visited[ny][nx] != 0 || map[ny][nx] != 0) continue;
                q.offer(new Node(ny, nx));
                visited[ny][nx] = visited[cur.y][cur.x] + 1;
                if (cur.y == turtle.y && cur.x == turtle.x) dir[ny][nx] = i;
                else dir[ny][nx] = dir[cur.y][cur.x];
            }
        }
        
        if (visited[n - 1][n - 1] == 0) return;
        
        int d = dir[n - 1][n - 1];
        int ny = turtle.y + dy[d];
        int nx = turtle.x + dx[d];
        
        map[turtle.y][turtle.x] = 0;

        turtle.y = ny;
        turtle.x = nx;
        if (turtle.y == n - 1 && turtle.x == n - 1) {
            ans[idx] = t;
            turtles[idx] = null;
            return;
        }
        map[turtle.y][turtle.x] = 2;
    }
    
    static void pressureIncrease() {
        for (int i = 0; i < k; i++) {
            mountains[i].nowP += 10;
        }
    }
    
    static void bomb(int y, int x, int h, int d) {
        h /= 2;
        if (h == 0) return;
        
        int ny = y + dy[d];
        int nx = x + dx[d];
        if (ny < 0 || nx < 0 || ny >= n || nx >= n || map[ny][nx] == 1) return;
        heat[ny][nx] += h;
        bomb(ny, nx, h, d);
    }
}
