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
    
    static class Cluster {
        int num;
        List<Node> cells;
        
        public Cluster(int num, List<Node> cells) {
            this.num = num;
            this.cells = cells;
        }
    }
    
    static int n, q;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        
        map = new int[n][n];
        for (int i = 1; i <= q; i++) {
            // 미생물 투입
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            
            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    map[y][x] = i;
                }
            }
            
            clearSplit();
            
            // 배양 용기 이동
            List<Node>[] cells = new ArrayList[q + 1];
            for (int j = 0; j <= q; j++) {
                cells[j] = new ArrayList<>();
            }
            
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    if (map[y][x] == 0) continue;
                    cells[map[y][x]].add(new Node(y, x));
                }
            }
            
            List<Cluster> clusters = new ArrayList<>();
            for (int j = 0; j <= q; j++) {
                int minY = n;
                int minX = n;

                for (Node cell : cells[j]) {
                    minY = Math.min(minY, cell.y);
                    minX = Math.min(minX, cell.x);
                }

                List<Node> normalized = new ArrayList<>();

                for (Node cell : cells[j]) {
                    normalized.add(new Node(
                        cell.y - minY,
                        cell.x - minX
                    ));
                }
                
                if (!cells[j].isEmpty()) {
                    clusters.add(new Cluster(j, normalized));
                }
            }
            

            
            Collections.sort(clusters, (c1, c2) -> {
                if (c1.cells.size() == c2.cells.size()) {
                    return c1.num - c2.num;
                }
                return c2.cells.size() - c1.cells.size();
            });
            
            int[][] newMap = new int[n][n];
            for (Cluster cluster : clusters) {
                boolean flag = false;
                for (int y = 0; y < n; y++) {
                    for (int x = 0; x < n; x++) {
                        if (check(y, x, cluster, newMap)) {
                            for (Node cell : cluster.cells) {
                                newMap[y + cell.y][x + cell.x] = cluster.num;
                            }
                            flag = true;
                            break;
                        }
                    }
                    if (flag) break;
                }
            }
            
            map = newMap;
            
            // 실험 결과 기록
            int[] area = new int[q + 1];
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    area[map[y][x]]++;
                }
            }
            
            boolean[][] checked = new boolean[q + 1][q + 1];
            
            long ans = 0;
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    if (map[y][x] == 0) continue;
                    if (y + 1 < n) {
                        if (map[y + 1][x] != 0 && map[y][x] != map[y + 1][x] && !checked[map[y][x]][map[y + 1][x]]) {
                            checked[map[y][x]][map[y + 1][x]] = true;
                            checked[map[y + 1][x]][map[y][x]] = true;
                            ans += area[map[y][x]] * area[map[y + 1][x]];
                        }
                    }
                    
                    if (x + 1 < n) {
                        if (map[y][x + 1] != 0 && map[y][x] != map[y][x + 1] && !checked[map[y][x]][map[y][x + 1]]) {
                            checked[map[y][x]][map[y][x + 1]] = true;
                            checked[map[y][x + 1]][map[y][x]] = true;
                            ans += area[map[y][x]] * area[map[y][x + 1]];
                        }
                    }
                }
            }
            
            bw.write(ans + "\n");
        }
        
        bw.flush(); 
    }
    
    static void clearSplit() {
        visited = new boolean[n][n];
        int[] cnt = new int[q + 1];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    cnt[map[i][j]]++;
                }
            }
        }
        
        for (int i = 1; i <= q; i++) {
            if (cnt[i] >= 2) {
                for (int y = 0; y < n; y++) {
                    for (int x = 0; x < n; x++) {
                        if (map[y][x] == i) map[y][x] = 0;
                    }
                }
            }
        }
    }
    
    static void dfs(int y, int x) {
        visited[y][x] = true;
        
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
            if (visited[ny][nx] || map[ny][nx] != map[y][x]) continue;
            dfs(ny, nx);
        }
    }
    
    static boolean check(int y, int x, Cluster cluster, int[][] newMap) {
        for (Node cell : cluster.cells) {
            int ny = y + cell.y;
            int nx = x + cell.x;
            if (ny < 0 || nx < 0 || ny >= n || nx >= n) return false;
            if (newMap[ny][nx] != 0) return false;
        }
        
        return true;
    }
}
