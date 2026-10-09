import java.io.*;
import java.util.*;

public class Main {    
    static class Leader {
        int f, b, y, x;
        
        public Leader(int f, int b, int y, int x) {
            this.f = f;
            this.b = b;
            this.y = y;
            this.x = x;
        }
    }
    
    static int n, t;
    static int[][] b;
    static int[][] f;
    static int[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        
        f = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                char c = s.charAt(j);
                if (c == 'T') {
                    f[i][j] = 1 << 1;
                } else if (c == 'C') {
                    f[i][j] = 1 << 2;
                } else {
                    f[i][j] = 1 << 3;
                }
            }
        }
        
        b = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                b[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        while(t-- > 0) {
            // 아침
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    b[i][j]++;
                }
            }
            
            // 점심
            // 그룹 결정
            visited = new int[n][n];
            int num = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j] == 0) {
                        dfs(i, j, num);
                        num++;
                    }
                }
            }
            
            // 대표자 결정
            List<Leader> leaders = new ArrayList<>();
            for (int g = 1; g < num; g++) {
                int maxY = -1, maxX = -1, max = 0;
                for (int y = 0; y < n; y++) {
                    for (int x = 0; x < n; x++) {
                        if (visited[y][x] != g) continue;
                        if (b[y][x] > max) {
                            max = b[y][x];
                            maxY = y;
                            maxX = x;
                        }
                    }
                }
                
                int cnt = 0;
                for (int y = 0; y < n; y++) {
                    for (int x = 0; x < n; x++) {
                        if (visited[y][x] != g) continue;
                        if (maxY != y || maxX != x) {
                            cnt++;
                            b[y][x]--;
                        }
                    }
                }
                b[maxY][maxX] += cnt;
                
                leaders.add(new Leader(f[maxY][maxX], b[maxY][maxX], maxY, maxX));
            }
            
            // 저녁
            
            // 대표자 정렬
            Collections.sort(leaders, (l1, l2) -> {
                if (Integer.bitCount(l1.f) == Integer.bitCount(l2.f)) {
                    if(l1.b == l2.b) {
                        if (l1.y == l2.y) {
                            return l1.x - l2.x;
                        }
                        return l1.y - l2.y;
                    }
                    return l2.b - l1.b;
                }
                
                return Integer.bitCount(l1.f) - Integer.bitCount(l2.f);
            });
            
            // 신앙심 전파
            boolean[][] defense = new boolean[n][n];
            for (Leader l : leaders) {
                if (defense[l.y][l.x]) continue;
                int d = l.b % 4;
                int y = l.y;
                int x = l.x;
                b[y][x] = 1;
                int a = l.b - 1;
                while(true) {
                    int ny = y + dy[d];
                    int nx = x + dx[d];
                    if (ny < 0 || nx < 0 || ny >= n || nx >= n) break;
                    if (a == 0) break;
                    
                    y = ny;
                    x = nx;
                    
                    if (f[l.y][l.x] == f[y][x]) continue;
                    if (a > b[y][x]) {
                        f[y][x] = f[l.y][l.x];
                        a -= b[y][x] + 1;
                        b[y][x]++;
                    } else {
                        f[y][x] |= f[l.y][l.x];
                        b[y][x] += a;
                        a = 0;
                    }
                    
                    defense[y][x] = true;
                }
            }
            
            // 신앙심 출력
            int[] ans = new int[7];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    ans[getIdx(f[i][j])] += b[i][j];
                }
            }
            
            for (int i = 0; i < 7; i++) {
                bw.write(ans[i] + " ");
            }
            bw.write("\n");
        }
        
        bw.flush(); 
    }
    
    static void dfs(int y, int x, int num) {
        visited[y][x] = num;
        
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
            if (visited[ny][nx] != 0 || f[ny][nx] != f[y][x]) continue;
            dfs(ny, nx, num);
        }
    }
    
    static int getIdx(int f) {
        if (f == 14) return 0;
        if (f == 6) return 1;
        if (f == 10) return 2;
        if (f == 12) return 3;
        if (f == 8) return 4;
        if (f == 4) return 5;
        return 6;
    }
}
