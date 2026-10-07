import java.io.*;
import java.util.*;

public class Main {
    static class Package {
        int id, y, x, h, w;
        boolean removed;
        
        public Package(int id, int y, int x, int h, int w) {
            this.id = id;
            this.y = y;
            this.x = x;
            this.h = h;
            this.w = w;
            this.removed = false;
        }
    }
    
    static int n, m;
    static int[][] map;
    static List<Package> packages = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new int[n][n];
        
        // 택배 투입
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken()) - 1;
            
            packages.add(new Package(k, 0, c, h, w));
            
            for (int y = 0; y < h; y++) {
                for (int x = c; x < c + w; x++) {
                    map[y][x] = k;
                }
            }
            
            drop();
        }
        
        int cnt = 0;
        while (true) {
            // 택배 하차 (좌측)
            PriorityQueue<Package> pq = new PriorityQueue<>((p1, p2) -> p1.id - p2.id);
            for (Package p : packages) {
                if (p.removed) continue;
                if (canRemoveLeft(p)) {
                    pq.add(p);
                }
            }
            
            if (!pq.isEmpty()) {
                Package p = pq.poll();
                p.removed = true;
                for (int y = p.y; y < p.y + p.h; y++) {
                    for (int x = p.x; x < p.x + p.w; x++) {
                        map[y][x] = 0;
                    }
                }
                cnt++;
                
                bw.write(p.id + "\n");
            }
            
            pq.clear();
            
            if (cnt == m) break;
            
            drop();
            
            // 택배 하차 (우측)
            for (Package p : packages) {
                if (p.removed) continue;
                if (canRemoveRight(p)) {
                    pq.add(p);
                }
            }
            
            if (!pq.isEmpty()) {
                Package p = pq.poll();
                p.removed = true;
                for (int y = p.y; y < p.y + p.h; y++) {
                    for (int x = p.x; x < p.x + p.w; x++) {
                        map[y][x] = 0;
                    }
                }
                cnt++;
                
                bw.write(p.id + "\n");
            }
            
            if (cnt == m) break;
            
            drop();
        }
        
        bw.flush(); 
    }
    
    static void drop() {
        boolean moved = true;
        
        while (moved) {
            moved = false;
            
            for (Package p : packages) {
                if (p.removed) continue;
                
                if (canDrop(p)) {
                    // map에서 제거
                    for (int i = p.y; i < p.y + p.h; i++) {
                        for (int j = p.x; j < p.x + p.w; j++) {
                            map[i][j] = 0;
                        }
                    }
                    
                    // y 증가
                    p.y++;
                    
                    // map에 다시 표시
                    for (int i = p.y; i < p.y + p.h; i++) {
                        for (int j = p.x; j < p.x + p.w; j++) {
                            map[i][j] = p.id;
                        }
                    }
                    
                    moved = true;
                }
            }
        }
    }
    
    static boolean canDrop(Package p) {
        if (p.y + p.h == n) return false;
        
        for (int x = p.x; x < p.x + p.w; x++) {
            if (map[p.y + p.h][x] != 0) {
                return false;
            }
        }
        
        return true;
    }
    
    static boolean canRemoveLeft(Package p) {
        for (int y = p.y; y < p.y + p.h; y++) {
            for (int x = 0; x < p.x; x++) {
                if (map[y][x] != 0) return false;
            }
        }
        
        return true;
    }
    
    static boolean canRemoveRight(Package p) {
        for (int y = p.y; y < p.y + p.h; y++) {
            for (int x = p.x + p.w; x < n; x++) {
                if (map[y][x] != 0) return false;
            }
        }
        
        return true;
    }
}
