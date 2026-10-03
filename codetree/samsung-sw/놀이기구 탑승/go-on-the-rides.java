import java.io.*;
import java.util.*;

public class Main {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        Set<Integer>[] sets = new HashSet[n * n + 1];
        
        for (int i = 0; i < n * n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n0 = Integer.parseInt(st.nextToken());
            sets[n0] = new HashSet<>();
            for (int j = 0; j < 4; j++) sets[n0].add(Integer.parseInt(st.nextToken()));
            
            int y = 0, x = 0, max1 = -1, max2 = -1;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (map[j][k] != 0) continue;
                    
                    int cnt1 = 0, cnt2 = 0;
                    for (int d = 0; d < 4; d++) {
                        int ny = j + dy[d];
                        int nx = k + dx[d];
                        if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
                        if (sets[n0].contains(map[ny][nx])) cnt1++;
                        else if (map[ny][nx] == 0) cnt2++;
                    }
                    
                    if (cnt1 > max1) {
                        max1 = cnt1;
                        max2 = cnt2;
                        y = j;
                        x = k;
                    } else if (cnt1 == max1 && cnt2 > max2) {
                        max2 = cnt2;
                        y = j;
                        x = k;
                    }
                }
            }
            map[y][x] = n0;
        }
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = 0;
                int x = map[i][j];
                for (int d = 0; d < 4; d++) {
                    int ny = i + dy[d];
                    int nx = j + dx[d];
                    if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
                    if (sets[x].contains(map[ny][nx])) {
                        if (tmp == 0) tmp = 1;
                        else tmp *= 10;
                    }
                }
                ans += tmp;
            }
        }
        
        bw.write(ans + "");
        bw.flush(); 
    }
}
